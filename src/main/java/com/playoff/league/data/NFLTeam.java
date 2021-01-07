package com.playoff.league.data;

import com.googlecode.objectify.annotation.Entity;

//@Entity
public enum  NFLTeam {

	PACKERS(CONF.NFC,"PACKERS.png" ,"PACKERS.json" ),
	SAINTS(CONF.NFC,"SAINTS.png","SAINTS.json"),
	SEAHAWKS(CONF.NFC,"SEAHAWKS.png" ,"SEAHAWKS.json" ),
	BUCS(CONF.NFC,"NINERS.png" ,"BUCS.json" ),
	RAMS(CONF.NFC,"EAGLES.png" ,"RAMS.json" ),
	BEARS(CONF.NFC,"BEARS.png","BEARS.json" ),
	FOOTBALL(CONF.NFC,"BEARS.png","FOOTBALL.json" ),

	CHIEFS(CONF.AFC,"CHIEFS.png","CHIEFS.json"),
	BILLS(CONF.AFC,"BILLS.png","BILLS.json"),
	STEELERS(CONF.AFC,"STEELERS.png","STEELERS.json"),
	TITANS(CONF.AFC,"TITANS.png","TITANS.json"),
	RAVENS(CONF.AFC,"RAVENS.png","RAVENS.json"),
	BROWNS(CONF.AFC,"BROWNS.png","BROWNS.json"),
	COLTS(CONF.AFC,"TEXANS.png","COLTS.json"),
	;

	private NFLTeam(CONF c, String imageLoc, String fileLoc)
	{
		this.conf = c;
		this.image = imageLoc;
		this.file = fileLoc;
	}
	private Long id;
	private CONF conf;
	private String image;
	private String file;

	public Long getId() {
		return id;
	}
	public String getImage() {
		return image;
	}
	public CONF getConf(){return this.conf; }
	public String getFileLocation(){return "teams/"+file;}
	public enum CONF{
		AFC,NFC;
	}
}
