package com.study;

public class Test {

	public static void main(String[] args) {
		Tv tv = Tv.getInstance();
		tv.isON();
		tv.getRemote().isON();
		tv.isON();
		tv.getRemote().isON();
		
		tv.channelUp();
		tv.getRemote().channelDown();
		tv.getRemote().channelDown();
		
		tv.volumeDown();
		tv.getRemote().volumeUp();
		tv.getRemote().volumeUp();
		tv.getRemote().volumeUp();
		
		tv.getRemote().Source();
		tv.Source();
		tv.getRemote().Source();
		
		tv.brightUp();
		tv.getRemote().brightUp();
		tv.brightDown();
		tv.getRemote().brightDown();
		tv.brightDown();
	}

}
