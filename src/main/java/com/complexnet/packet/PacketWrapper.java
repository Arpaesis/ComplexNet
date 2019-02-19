package com.complexnet.packet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import simplenet.Client;
import simplenet.packet.Packet;

public class PacketWrapper
{

	Packet packet = Packet.builder();

	private PacketWrapper()
	{
	}

	public static PacketWrapper builder()
	{
		return new PacketWrapper();
	}

	public void writeAndFlush(Client client)
	{
		packet.writeAndFlush(client);
	}

	public PacketWrapper putFile(Path path) throws IOException
	{
		int fileSize = (int) Files.size(path);
		
		if (Files.exists(path))
		{
			packet.putInt(fileSize);
			System.out.println(Files.readAllBytes(path).length);
			packet.putBytes(Files.readAllBytes(path));
		}
		else
		{
			// TODO: Handle.
		}
		return this;
	}

	public PacketWrapper putBoolean(boolean value)
	{
		packet.putBoolean(value);
		return this;
	}

	public PacketWrapper putChar(char value)
	{
		packet.putChar(value);
		return this;
	}

	public PacketWrapper putByte(int value)
	{
		packet.putByte(value);
		return this;
	}

	public PacketWrapper putShort(int value)
	{
		packet.putShort(value);
		return this;
	}

	public PacketWrapper putInt(int value)
	{
		packet.putInt(value);
		return this;
	}

	public PacketWrapper putFloat(float value)
	{
		packet.putFloat(value);
		return this;
	}

	public PacketWrapper putDouble(double value)
	{
		packet.putDouble(value);
		return this;
	}

	public PacketWrapper putLong(long value)
	{
		packet.putLong(value);
		return this;
	}

	public PacketWrapper putString(String value)
	{
		packet.putString(value);
		return this;
	}
}
