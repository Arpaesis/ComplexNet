package com.complexnet;

import com.complexnet.client.ExtendedClient;

import simplenet.Server;

public class ServerLaunch
{

	public static void main(String[] args)
	{
		var server = new Server();

		server.onConnect(client ->
		{

			System.out.println(client + " has connected!");

			client.readByteAlways(opcode ->
			{
				if (opcode == 1)
				{
					new ExtendedClient(client).readFile("folder/hello.txt", file ->
					{
						System.out.println("successfully received file!");
					});
				}
			});

			client.preDisconnect(() -> System.out.println(client + " is about to disconnect!"));

			client.postDisconnect(() -> System.out.println(client + " has successfully disconnected!"));
		});

		server.bind("localhost", 43594);
	}
}
