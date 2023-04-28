package com.sp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sp.model.Poney;

@Service
public class PoneyDao {
	private List<Poney> myPoneyList;
	private Random randomGenerator;
	
	public PoneyDao() {
		myPoneyList=new ArrayList<>();
		randomGenerator = new Random();
		createPoneyList();
	}

	private void createPoneyList() {
		
		Poney p1=new Poney("John", "pink", "super pink", "http://ekladata.com/9-cPSlYvrenNHMVawFmf_gLx8Jw.gif");
		Poney p2=new Poney("Roberto", "blue", "super lazy", "http://ekladata.com/JEVyY9DkwX4vVkakeBfikSyPROA.gif");
		Poney p3=new Poney("Anna", "orange", "super music girl", "http://ekladata.com/fMJl--_v-3CmisaynTHju1DMeXE.gif");
		Poney p4=new Poney("Angry Joe", "purple", "super angry power", "http://ekladata.com/AmbNNNvv-4YFEMZR8XD8e54WoHc.gif");
		Poney p5=new Poney("Ursula", "green", "super cloning power", "http://ekladata.com/CXJhi2YLUbNz6__e0Ct6ZP-XOds.gif");
		
		myPoneyList.add(p1);
		myPoneyList.add(p2);
		myPoneyList.add(p3);
		myPoneyList.add(p4);
		myPoneyList.add(p5);
	}
	public List<Poney> getPoneyList() {
		return this.myPoneyList;
	}
	public Poney getPoneyByName(String name){
		for (Poney poneyBean : myPoneyList) {
			if(poneyBean.getName().equals(name)){
				return poneyBean;
			}
		}
		return null;
	}
	public Poney getRandomPoney(){
		int index=randomGenerator.nextInt(this.myPoneyList.size());
		return this.myPoneyList.get(index);
	}

	public Poney addPoney(String name, String color, String superPower, String imgUrl) {
		Poney p=new Poney(name, color, superPower, imgUrl);
		this.myPoneyList.add(p);
		return p;
	}
}
