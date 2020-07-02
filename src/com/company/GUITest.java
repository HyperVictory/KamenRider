package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GUITest {

    @BeforeEach
    void setUp() {
        System.out.println("表示层测试....");
    }

    @AfterEach
    void tearDown() {
        System.out.println("表示层测试结束....");
    }

    @Test
    void initGUI() {
        GUI frame;//启动功能测试
        frame = new GUI("LifeGame");
        Scanner input=new Scanner(System.in);
        int n;
        int x,y;
        n=input.nextInt();//只是实现一个暂停功能，充分利用了单元测试中不能输入
    }


    @Test
    void clear() {
        //清零，退出功能，基本借用了业务层的方法，因为业务层已经通过故不进行测试
        int cellmax[][]=new int[40][40];
        cellmax[1][1]=0;
        cellmax[0][2]=1;
        cellmax[0][1]=1;
        cellmax[1][3]=1;
        cellmax[2][1]=0;
        cellmax[2][2]=0;
        cellmax[2][3]=0;
        service Service=new service();
        GUI gui=new GUI();
        gui.initGUI();
        Service.init();
        Service.get(cellmax);//使数组cellmax初始化
       gui.Cellchange(cellmax);
        assertEquals(0,cellmax[1][3] );
    }
    @Test
    void Generation(){//迭代
        GUI gui=new GUI();
        act ACT=new act();
        service Service=new service();
        int cellmax[][]=new int[40][40];
        cellmax[1][2]=0;
        cellmax[1][1]=0;
        cellmax[0][2]=1;
        cellmax[0][1]=1;
        cellmax[1][3]=1;
        cellmax[2][1]=0;
        cellmax[2][2]=0;
        cellmax[2][3]=0;
        Service.print();
        ACT.Generation(cellmax,Service);
        Service.print();
        assertEquals(1, cellmax[1][2]);
    }

    @Test
    void  randomInit() {//初始化按钮测试
        GUI gui=new GUI();
        service Service=new service();

        int cellmax[][]=new int[40][40];
        Service.randomCell();
        Service.get(cellmax);//随机化
        gui.initGUI();
        gui.Cellchange(cellmax);
        Scanner input=new Scanner(System.in);
        int n;
        int x,y;
        n=input.nextInt();//只是实现一个暂停功能，充分利用了单元测试中不能输入
    }
    @Test
    void cellchange() {
        GUI gui=new GUI();

        gui.initGUI();
        int cellmax[][]=new int[40][40];
        cellmax[1][1]=0;
        cellmax[0][2]=1;
        cellmax[0][1]=1;
        cellmax[1][3]=1;
        cellmax[2][1]=0;
        cellmax[2][2]=0;
        cellmax[2][3]=0;
        gui.Cellchange(cellmax);
        GUI frame;

        //  gui.main();

        Scanner input=new Scanner(System.in);
        int n;
        int x,y;
        n=input.nextInt();//只是一场梦
    }
    }
