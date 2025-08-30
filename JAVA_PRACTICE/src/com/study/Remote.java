package com.study;

public class Remote { 
	private Tv tv;
	
	public Remote(Tv tv) {
		this.tv = tv;
	}

	public void channelUp(){
		tv.channelUp();
	}
	
	public void channelDown(){
		tv.channelDown();
	}
		 	
	public void isON() {
		tv.isON();
	}
		
	public void volumeUp() {
		tv.volumeUp();
	}
		
	public void volumeDown() {
		tv.volumeDown();
	}
		
	public void brightUp() {
		tv.brightUp();
	}
		
	public void brightDown() {
		tv.brightDown();
	}
		
	public void Source(){
		tv.Source();
	}
}