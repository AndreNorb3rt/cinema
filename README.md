Задание на летнюю практику
Разработать информационную систему “Продажа билетов в кинотеатре”, включающую следующие атрибуты и сущности:

*Кинозал
  Название
  Описание
*Место
  Кинозал
  Номер ряда
  Номер места в ряду
  Стоимость по умолчанию
*Фильм
  Название
  Описание
  Длительность в минутах
*Сеанс
  Кинозал
  Фильм
  Время начала
  Время окончания
*Билет
  Сеанс
  Место в кинозале
  Стоимость
*Клиент
  ФИО
  Список купленных билетов
 

Создать необходимые экраны для сущностей.
При просмотре информации о билете должна также отображаться информация о кинозале, фильме и временам начала и окончания сеанса.
Должна быть запрещена возможность создавать такие сеансы, длительность которых меньше длительности фильма.
Два клиента не могут купить один и тот же билет.
При создании очередного сеанса автоматически должны создаваться сущности билетов на все места в кинозале на этот сеанс. Сеанс нельзя удалить, если на него уже продан хотя бы 1 билет. Если билеты не проданы, то сеанс удаляется вместе со всеми билетами на него.
В системе должен быть экран, демонстрирующий купленные и свободные места на выбранный сеанс.
