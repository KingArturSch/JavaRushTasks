package com.javarush.task.task17.task1710.Ilyas;
import com.javarush.task.task17.task1710.Person;
import com.javarush.task.task17.task1710.Sex;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
/*
CRUD

CrUD - Create, Update, Delete

Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u - обновляет данные человека с данным id
-d - производит логическое удаление человека с id, заменяет все его данные на null
-i - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990

Требования:
1. Класс Solution должен содержать public static поле allPeople типа List.
2. Класс Solution должен содержать статический блок, в котором добавляются два человека в список allPeople.
3. При запуске программы с параметром -с программа должна добавлять человека с заданными параметрами в конец списка allPeople, и выводить id (index) на экран.
4. При запуске программы с параметром -u программа должна обновлять данные человека с заданным id в списке allPeople.
5. При запуске программы с параметром -d программа должна логически удалять человека с заданным id в списке allPeople.
6. При запуске программы с параметром -i программа должна выводить на экран данные о человеке с заданным id по формату указанному в задании.
*/
public class Solution{
	public static List<Person> allPeople=new ArrayList<>();
	static{
		allPeople.add(Person.createMale("Иванов Иван",new Date()));  //сегодня родился    id=0
		allPeople.add(Person.createMale("Петров Петр",new Date()));  //сегодня родился    id=1
	}
	public static void main(String[] args) throws ParseException{
		if("c".equals(args[0])){
			System.out.println(allPeople.size()-1);
			if("м".equals(args[2]))allPeople.add(Person.createMale(args[1],new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
			else if("ж".equals(args[2]))allPeople.add(Person.createFemale(args[1],new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(args[3])));
			System.out.println(allPeople.size()-1);
		}else if("u".equals(args[0])){
			Person p=allPeople.get(Integer.parseInt(args[1]));
			p.setName(args[2]);
			if("м".equals(args[3])) p.setSex(Sex.MALE);
			else if("ж".equals(args[3])) p.setSex(Sex.FEMALE);
			p.setBirthDay(new SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH).parse(args[4]));
		}else if("d".equals(args[0])){
			Person p=allPeople.get(Integer.parseInt(args[1]));
			p.setName(null);
			p.setSex(null);
			p.setBirthDay(null);
		}else if("i".equals(args[0])){
			Person p=allPeople.get(Integer.parseInt(args[1]));
			System.out.println(p.getName()+" "+(p.getSex().equals(Sex.MALE)?"м":p.getSex().equals(Sex.FEMALE)?"ж":null)+new SimpleDateFormat(" dd-MM-yyyy",Locale.ENGLISH).format(p.getBirthDay()));
		}
	}
}