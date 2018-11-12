package mvc;

import java.util.Scanner;

public class CityTest {
	public static void main(String[] args) {
		CityDAO cDao = new CityDAO();
		CityDTO cDto = new CityDTO();

		Scanner sc = new Scanner(System.in);
//		System.out.println("* * * * * * * * menu * * * * * * * *");
//		System.out.println("1.select 2.insert 3.update 4.delete");
//		System.out.print(">> ");
//		String key = sc.next();
//

//		/*insert*/
//		System.out.println("insert");
//		System.out.print("city name >> ");
//		String ct_nm = sc.nextLine();
//		System.out.print("Country Code >> ");
//		String cc = sc.nextLine();
//		System.out.print("District >> ");
//		String dt = sc.nextLine();
//		System.out.print("Population >> ");
//		int pp = sc.nextInt();
//
//		cDto.setName(ct_nm);
//		cDto.setCc(cc);
//		cDto.setDst(dt);
//		cDto.setPp(pp);
//
//		cDao.insertCity(cDto);
//
//		System.out.println("insert finish");

//		/*Update*/
//		System.out.println("Update");
//		System.out.print("city name >> ");
//		String ct_nm = sc.nextLine();
//		System.out.print("Population >> ");
//		int pp = sc.nextInt();
//		cDto.setName(ct_nm);
//		cDto.setPp(pp);
//
//		cDao.updateCity(cDto);
//		System.out.println("update finish");

//		/*Delete*/
//		System.out.print("delete \nDistrict >> ");
//		String name = sc.nextLine();
//		cDto.setDst(name);
//
//		cDao.deleteCity(cDto);
//		System.out.println("Delete finish");

//		/*selectAll*/
//
//		System.out.println("select all");
//		System.out.print("View Korea city Limit count >> ");
//		int n = sc.nextInt();
//
//		List<CityDTO> citylist = cDao.selectCity(n);
//		for (CityDTO cityDTO : citylist) {
//			System.out.println(cityDTO.toString());
//		}

//		/*selectone*/
//
//		System.out.println("select one");
//		System.out.print("id >> ");
//		int n = sc.nextInt();
//
//		CityDTO city = cDao.selectOneCity(n);
//		System.out.println(city.toString());

		sc.close();

	}
}
