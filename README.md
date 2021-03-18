# hakaton-HouseAdvice
Онлайн собрание жильцов для решения общедомовых вопросов.
При проектировании учитывалась надежность голосования - устойчивость к вбросам голосов, устойчивость к изменению результатов голосования (эти решения не отражены в приложении)
Помимо основной функции голосования, присутствует:
- Доска объявлений для реализации "чистого подъезда"
- Каналы для связи с ТСЖ (в рамках хакатона успели только добавить номера телефонов)
- Форум жильцов
- Профиль


## Примечание
Приложение было создано в рамках хакатона "Цифровой прорыв". Многие вещи делались именно в угоду скорости разработки.


## Используемые технологии и подходы 
- Урезаный Clean Architecture. Был упразднен domain-слой, опять же для скорости разработки
- Смесь MVP/MVVM/MVI. В каждом конкретном случае выбирался один(или сразу несколько) подходов, наиболее простых в конкретной ситуации.
- Многомодульная архитектура
- SingleActvity-подход
- Анимации между переходами фрагментов
- Koin в качестве DI
- Coroutines
- Android Arch(viewmodel, livedate, lifecycle)
- Была создана CustomView
- Фишки при работе с gradle
- Push-уведомления(временно отключена)
- QR-коды и диплинки

## Демо

Скачать приложение:  
[Google Play](https://play.google.com/store/apps/details?id=ru.endroad.houseadvice&hl=ru&gl=US)

#### Скриншоты
![HouseAdvice_Screenshot_1](https://user-images.githubusercontent.com/42086955/111638149-a732e080-882c-11eb-8aaa-e74133ec1e21.jpg)
![HouseAdvice_Screenshot_2](https://user-images.githubusercontent.com/42086955/111638152-a7cb7700-882c-11eb-96a9-ab6f45108449.jpg)

![HouseAdvice_Screenshot_3](https://user-images.githubusercontent.com/42086955/111638154-a8640d80-882c-11eb-8403-3662c346cd5f.jpg)
![HouseAdvice_Screenshot_4](https://user-images.githubusercontent.com/42086955/111638156-a8640d80-882c-11eb-997f-972f55ba8cd3.jpg)

![HouseAdvice_Screenshot_5](https://user-images.githubusercontent.com/42086955/111638159-a8640d80-882c-11eb-94a8-994848e8c23d.jpg)
![HouseAdvice_Screenshot_6](https://user-images.githubusercontent.com/42086955/111638164-a8fca400-882c-11eb-8500-5661142926b6.jpg)

![HouseAdvice_Screenshot_7](https://user-images.githubusercontent.com/42086955/111638165-a8fca400-882c-11eb-8ba5-3a420bcaa59c.jpg)

## Хакатон "Цифровой прорыв"
Попадание в шорт-лист и проход в финал.
Состав команды состоял из двух человек - разработчик и маркетолог. Составы остальных команд 3-5 человек.
Общее количество команд в нашем кейсе - 21

В рамках хакатона была выполнена работа:
- Изучение проблемы
- Анализ и поиск оптимальных решений
- Реализация одного из решений в виде прототипа
- Составление полного описания решения
- Презентация

#### Сертификат
![image](https://user-images.githubusercontent.com/42086955/111668078-f33f4e80-8847-11eb-8f98-e6e23dd0b430.png)

[Оригинал](https://github.com/RasM24/Samples-HouseAdvice/files/6165981/certificate.1.pdf)

