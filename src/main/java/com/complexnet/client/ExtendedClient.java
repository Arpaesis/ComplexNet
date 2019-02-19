package com.complexnet.client;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;

import simplenet.Client;

public class ExtendedClient extends Client
{

	public ExtendedClient()
	{
		super();
	}

	public ExtendedClient(Client client)
	{
		super(client);
	}

	public String getIpAddress()
	{
		try
		{
			return this.getChannel().getRemoteAddress().toString();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public void readFile(String fileName, Consumer<Path> consumer)
	{
		Path path = Path.of(fileName);

		this.readInt(fileSize ->
		{
			this.readBytes(fileSize, bytes ->
			{
				try
				{
					Files.write(path, bytes);
					consumer.accept(path);
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			});
		});
	}
}
