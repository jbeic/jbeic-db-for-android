package com.jbeic.db.test;

import java.util.HashMap;
import java.util.Map;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.junit.Test;

import com.jbeic.db.interf.JBeic;


public class TestDB {
	@Test
	public void test1(){
		JBeic.create(new MyTest());
		JBeic.create(new StudenBean());

	}
	
}
