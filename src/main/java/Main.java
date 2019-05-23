//package main.java;

import java.util.List;
import java.util.Scanner;

import model.containers.Century;
import model.event.Birthday;
import model.event.Event;
import model.event.Meeting;
import services.FileService;
import services.Service;
import services.TableService;
import dao.BirthdayEntity;
import dao.MeetingEntity;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();
        FileService fileService = new FileService();
        Century century = new Century();
        String[] str;
        Scanner scanner = new Scanner(System.in);
        service.setEvent(century, 1, 1, 1, 1, new Meeting("Kolya", "Important"));
        service.setEvent(century, 1, 1, 1, 2, new Birthday("Valya", "Awesome", "Car"));
        TableService tableService = new TableService();
        MeetingEntity meetingEntity = new MeetingEntity();
        meetingEntity.setYear(1);
        meetingEntity.setDay(1);
        meetingEntity.setMonth(1);
        meetingEntity.setHour(1);
        meetingEntity.setName("Nikita");
        meetingEntity.setDescription("adsfa");
        tableService.save(meetingEntity);


        for (; ; ) {
            System.out.println("Выберите действие:\n1.Посмотреть\n2.Добавить\n3.Удалить\n4.Сохранить\n5.Загрузить\n6.Выход");
            try {
                switch (scanner.nextInt()) {
                    case (1):
                        System.out.println("Просмотреть:\n1.Конкретное\n2.За период\n");
                        switch (scanner.nextInt()) {
                            case (1):
                                System.out.println("Введите год, месяц, день, час");
                                str = scanner.next().split(",");
                                System.out.println(
                                        service.getEvent(
                                                century,
                                                Integer.parseInt(str[0]),
                                                Integer.parseInt(str[1]),
                                                Integer.parseInt(str[2]),
                                                Integer.parseInt(str[3])).toString()
                                );
                                break;
                            case (2):
                                System.out.println("Введите два года");
                                str = scanner.next().split(",");
                                List<Event> events = service.periodEvents(
                                        century,
                                        Integer.parseInt(str[0]),
                                        Integer.parseInt(str[1]));
                                for (Event event : events)
                                    System.out.println(event.toString());
                                break;
                        }
                        break;

                    case (2):
                        System.out.println("Что добавить?\n1. Встречу\n2. День рождения");
                        switch (scanner.nextInt()) {
                            case (1):
                                System.out.println("Введите год, месяц, день, час, имя, описание");
                                str = scanner.next().split(",");
                                service.setEvent(
                                        century,
                                        Integer.parseInt(str[0]),
                                        Integer.parseInt(str[1]),
                                        Integer.parseInt(str[2]),
                                        Integer.parseInt(str[3]),
                                        new Meeting(str[4], str[5])
                                );
                                break;
                            case (2):
                                System.out.println("Введите год, месяц, день, час, имя, описание, подарок");
                                str = scanner.next().split(",");
                                service.setEvent(
                                        century,
                                        Integer.parseInt(str[0]),
                                        Integer.parseInt(str[1]),
                                        Integer.parseInt(str[2]),
                                        Integer.parseInt(str[3]),
                                        new Birthday(str[4], str[5], str[6])
                                );
                                break;
                            default:
                                System.out.println("Выберите правильный номер");
                        }
                        break;

                    case (3):
                        System.out.println("Введите год, месяц, день, час");
                        str = scanner.next().split(",");
                        service.deleteEvent(
                                century,
                                Integer.parseInt(str[0]),
                                Integer.parseInt(str[1]),
                                Integer.parseInt(str[2]),
                                Integer.parseInt(str[3])
                        );
                        System.out.println("Удалил");
                        break;
                    case (4):
                        System.out.println("Выберите вариант:\n1.Serialize\n2.JSON\n3.XML\n");
                        int t = scanner.nextInt();
                        System.out.println("Введите имя файла");
                        String name = scanner.next();
                        switch (t) {
                            case (1):
                                fileService.serialize(century, name);
                                break;

                            case (2):
                                fileService.JSONize(century, name);
                                break;

                            case (3):
                                fileService.XMLize(century, name);
                                break;

                        }
                        break;

                    case (5):
                        System.out.println("Введите имя файла");
                        name = scanner.next();
                        System.out.println("Введите формат");
                        String format = scanner.next();
                        century = fileService.loadFromFile(name,format);
                        break;

                    case (6):
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Выберите правильный номер");
                }
            } catch (Exception exception) {
                System.out.println(exception.toString());
            }
        }
    }
}
