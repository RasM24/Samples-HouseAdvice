# hakaton-HouseAdvice

## Примечение
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
