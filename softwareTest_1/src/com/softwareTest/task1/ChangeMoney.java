package com.softwareTest.task1;

public class ChangeMoney {
	int []money = {50,20,10,5,1};
	int []numOfMoney= {1,1,1,2,3};
	
	public boolean judge(int num) {
		while(num>0){
			//记录本轮遍历能不能找钱的标记
			boolean flag=false;
			
			for(int i=0;i<=money.length-1;i++) {
				if(num>=money[i]&&numOfMoney[i]>0){
					num-=money[i];
					numOfMoney[i]-=1;
					flag=true;
					break;
				}
			}
			if(flag==false) return false;
		}
		
		return true;
	}
}
