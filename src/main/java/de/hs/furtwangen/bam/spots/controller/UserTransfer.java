package de.hs.furtwangen.bam.spots.controller;



public class UserTransfer
{

	private final String name;



	public UserTransfer(String userName)
	{
		this.name = userName;
	}


	public String getName()
	{
		return this.name;
	}


}