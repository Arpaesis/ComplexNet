package com.complexnet;

import java.io.IOException;
import java.nio.file.Path;

import com.complexnet.client.ExtendedClient;
import com.complexnet.packet.PacketWrapper;

public class ClientLaunch
{

	public static void main(String[] args)
	{
		var client = new ExtendedClient();
		
		client.onConnect(() -> {
			
			System.out.println("Sending file...");
			
			try
			{
				PacketWrapper.builder().putByte(1).putFile(Path.of("hello.txt")).writeAndFlush(client);
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		});
		
		client.connect("localhost", 43594);
	}
}
