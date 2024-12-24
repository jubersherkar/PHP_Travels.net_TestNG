package com.snd.managers;

import com.snd.dataProvider.ConfigReader;

public class FileReaderManager 
{
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigReader configReader;

	private FileReaderManager()
	{

	}
	public static FileReaderManager getInstance()
	{
		return fileReaderManager;
	}
	public ConfigReader getConfigReader()
	{
		if(configReader == null)
		{
			configReader = new ConfigReader();
			return configReader;
		}
		else
		{
			return configReader;
		}
	}
}
