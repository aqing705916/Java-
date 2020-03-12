package com.huawei.classroom.student.homework_1;


public class Computer {
    
    void com1() {
    	String Name = "computer1";
        Intel in = new Intel();
        Samsung sam = new Samsung();
        Seagate swa = new Seagate();
        Asus as = new Asus();
        int price = in.price + sam.price + swa.price + as.price;
		System.out.print("\n" + in.Name + " " + in.price + "\n");
		in.work();
		System.out.print("\n" + sam.Name + " " + sam.price + "\n");
		sam.work();
		System.out.print("\n" +swa.Name + " " + swa.price + "\n");
		swa.work();
		System.out.print("\n" + as.Name + " " + as.price + "\n");
		as.work();
		System.out.print("\n" + Name + " " + price);
	}
    void com2() {
    	String Name = "computer2";
        AMD amd = new AMD();
        Samsung sam = new Samsung();
        Seagate swa = new Seagate();
        Gigabyte gig = new Gigabyte();
        int price = amd.price + sam.price + swa.price + gig.price;
		System.out.print("\n"  + amd.Name + " " + amd.price + "\n");
		amd.work();
		System.out.print("\n" + sam.Name + " " + sam.price + "\n");
		sam.work();
		System.out.print("\n" +swa.Name + " " + swa.price + "\n");
		swa.work();
		System.out.print("\n" + gig.Name + " " + gig.price + "\n");
		gig.work();
		System.out.print("\n" + Name + " " + price);
    }
    void com3() {
    	String Name = "computer3";
        Intel in = new Intel();
        Kingston kin = new Kingston();
        WestDigitals swa = new WestDigitals();
        Asus as = new Asus();
        int price = in.price + kin.price + swa.price + as.price;
		System.out.print("\n" + in.Name + " " + in.price + "\n");
		in.work();
		System.out.print("\n" + kin.Name + " " + kin.price + "\n");
		kin.work();
		System.out.print("\n" +swa.Name + " " + swa.price + "\n");
		swa.work();
		System.out.print("\n" + as.Name + " " + as.price + "\n");
		as.work();
		System.out.print("\n" + Name + " " + price);
    }
}
