package cn.pzhu.gjp.view;

import cn.pzhu.gjp.controller.ZhangWuController;
import cn.pzhu.gjp.domain.ZhangWu;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/*
 * 视图层，用户看到和操作的界面
 * 数据传递给controller层实现
 * 成员位置，创建controller对象
 */
public class MainView {
	private ZhangWuController controller=new ZhangWuController();
	/*
	 * 实现界面效果
	 * 完成键盘输入
	 */
	@Test
	public void run(){
		//创建Scanner类对象，反复键盘输入
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println("---------------记账软件---------------");
			System.out.println("1.添加账务　2.编辑账务　3.删除账务　4.查询账务　5.退出系统");
			System.out.println("请输入要操作的功能序号[1-5]:");
			//接受用户的菜单选择
			int choose=sc.nextInt();
			//对选择的菜单判断，调用不同的功能
			switch(choose){
				case 1:
//					添加账务
					addZhangWu();
					break;
				case 2:
//					编辑账务
					editZhangWu();
					break;
				case 3:
//					删除账务
					deleteZhangWu();
					break;
				case 4:
//					查询账务
					selectZhangWu();
					break;
				case 5:
					System.exit(0);
					break;
				
			}
		}
	}
	/*
	 * 定义一个方法，实现账务的删除
	 * 实现思想：
	 * 		接受用户输入，出入一个主键数据
	 * 		调用控制层方法，传递一个主键
	 */
	public void deleteZhangWu(){
		//调用查询所有数据的功能，显示出来
		//看到所有数据，从中选择一项，进行删除
		selectAll();
		System.out.println("你选择的是删除功能，输入序号");
		int zwid=new Scanner(System.in).nextInt();
		//调用控制层方法，传递主键id即可
		controller.deleteZhangWu(zwid);
		System.out.println("删除账务成功");
	}
	/*
	 * 定义一个方法，实现对账务的编辑功能
	 * 实现思想：
	 * 		接受用户输入
	 * 		数据的信息，转化为ZhangWu对象
	 *		 调用控制层的方法，传递ZhangWu对象，实现编辑
	 */
	public void editZhangWu(){
		//调用查询所有账务数据的功能，显示出来
		//看到所有数据，从中选择一项，进行修改
		selectAll();
		System.out.println("选择的是修改数据的功能，请输入修改的数据：");
		Scanner sc=new Scanner(System.in);
		//接受用户的数据
		System.out.println("输入ID：");
		int zwid=sc.nextInt();
		System.out.println("输入分类名称：");
		String flname=sc.next();
		System.out.println("输入金额：");
		double money=sc.nextDouble();
		System.out.println("输入账户：");
		String zhanghu=sc.next();
		System.out.println("输入日期：格式xxxx-xx-xx：");
		String createtime=sc.next();
		System.out.println("输入具体描述：");
		String description=sc.next();
		//封装为对象
		//输入的ID，必须封装为对象
		ZhangWu zw=new ZhangWu(zwid, flname, money, zhanghu, createtime, description);
		//调用controller层的方法，进行修改
		controller.editZhangWu(zw);
		System.out.println("账务修改成功");
	}
	/*
	 * 定义一个方法addZhangWu
	 * 添加账务的方法，用户在界面选择1是调用
	 * 实现思想：
	 * 		接受键盘输入
	 */
	public void addZhangWu(){
		System.out.println("你选择的是添加账务的功能，请输入一下内容：");
		Scanner sc=new Scanner(System.in);
		System.out.println("输入分类名称：");
		String flname=sc.next();
		System.out.println("输入金额：");
		double money=sc.nextDouble();
		System.out.println("输入账户：");
		String zhanghu=sc.next();
		System.out.println("输入日期：格式xxxx-xx-xx：");
		String createtime=sc.next();
		System.out.println("输入具体描述：");
		String description=sc.next();
		//将接受的数据，传递给controller层，传递参数
		//将用户输入的数据封装为一个zhangwu对象
		ZhangWu zw=new ZhangWu(0,flname,money,zhanghu,createtime,description);
		controller.addZhangWu(zw);
		System.out.println("添加账务成功！");
		}
	/*
	 * 定义一个方法selectZhangWu()
	 * 显示查询的方式1所有查询 2条件查询
	 * 接受用户的选择
	 */
	public void selectZhangWu(){
		System.out.println("1:查询所有   2：条件查询");
		Scanner sc=new Scanner(System.in);
		int selectChooser=sc.nextInt();
		//判断用户的选择，调用不同的功能
		switch(selectChooser){
		case 1:
			//查询所有的方法
			selectAll();
			break;
		case 2:
			select();
			//条件查询的方法
			break;
		}
	}
	/*
	 * 定义方法，实现查询所有的账务数据
	 */
	public void selectAll(){
		//调用控制层中的方法，查询所有账务数据
		List<ZhangWu> list=controller.selectAll();
		if(list.size()!=0)
			print(list);
		else
			System.out.println("没有查询到数据");
	}
	//输出账务数据的方法，接受List集合，遍历集合,输出表格
	private void print(List<ZhangWu> list) {
		//输出表头
		System.out.println("ID\t\t类别\t\t账户\t\t金额\t\t时间\t\t\t\t说明");
		//遍历集合
		for(ZhangWu zw:list){
			System.out.println(zw.getZwid()+"\t\t"+zw.getFlname()+"\t\t"+zw.getZhanghu()+"\t\t"+
		zw.getMoney()+"\t\t"+zw.getCreatetime()+"\t\t\t"+zw.getDescription());
		}
	}
	/*
	 * 定义方法，实现条件查询
	 * 用户的输入日期，开始日期和结束日期
	 * 传递到controller的方法，传递两个日期参数
	 * 获取controller查询的结果集，打印出来
	 */
	public void select(){
		System.out.println("你选择的是条件查询，输入日期格式xxxx-xx-xx");
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入开始日期：");
		String startDate=sc.nextLine();
		System.out.print("请输入结束日期：");
		String endDate=sc.nextLine();
		//调用controller层的方法，传递日期，获得结果集
		List<ZhangWu> list=controller.select(startDate, endDate);
		if(list.size()!=0)
			print(list);
		else
			System.out.println("没有查询到数据");
	}
}
