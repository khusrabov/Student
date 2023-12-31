Java ООП:

Данное задание является стартовым для курса и включает несколько целей:
Отработка навыка решения типовых объектно-ориентированных задач с использованием языка Java. В ходе выполнения работы необходимо разработать группу классов, которые реализуют прописанные в задании требования.
Отработать навык формирования исполняемого приложения на языке Java
Отработать навык упаковки Java приложений в исполняемый архив.
Задание состоит из набора требований, каждое из которых оценивается в определенное количество баллов. 
Для первых трех заданий оценка производится путем код ревью представленного решения, на предмет его соответствия объектно-ориентированному подходу. В случае выполнения решения процедурным подходом оценка снижается, или решение отправляется на переделку. Для проверки соответствия ООП подходу, к каждой части задания приложены критерии оценивания. 
Следующие два задания направлены на отработку навыка формирования исполняемого приложения. Для этого необходимо реализовать инфраструктуру с main методом, который будет исполняем и обладать консольным интерфейсом. 
Последнее задание является бонусным и может быть выполнено при наличии знаний о модульном тестировании с использованием Java.
Итого, за работу можно получить 6 основных и один бонусный балл.

Часть 1. Разработка базового класса
Необходимо разработать класс Студент. Данный класс должен отвечать следующим требованиям:
Имеет имя (строка)
Имеет список оценок (числовой)
Имя можно изменить или узнать в любой момент времени
Оценки можно добавлять, удалять и просматривать
Два Студента равны если у них одинаковые имена и список оценок
Текстовое представление студента имеет вид: “Имя: [оценка1, оценка2,…,оценкаN]”
Студент может быть создан двумя способами:
  с указанием имени
  с указанием имени и списка оценок.


Часть 2. Добавление условий.
Необходимо внести следующие изменения в базовый код Студента:
Тип оценки может быть не только числом, но вообще любым типом данных, например строкой или датой. Тип оценки указывается при создании объекта.
При создании объекта Студента ему может быть задано указание на то, что является корректной оценкой, а что нет (например четные числа в диапазоне от 1 до миллиона, или слова “зачет” и “незачет”). Если признак корректности не задан, значит все значения данного типа данных являются корректными оценками.
При попытке добавить Студенту некорректную оценку должно выбрасываться исключение.
Не должно быть способа добавить некорректную оценку.

Часть 3. Отмена.
Необходимо внести следующие изменения в код Студент полученный в части 2:
Добавьте Студенту метод отмены последнего действия. Поскольку у Студента можно изменить имя, добавить или удалить оценку, то отмена действия будет приводить к удалению или добавлению оценки либо возвращению предыдущей версии имени. Метод отмены можно вызывать до тех пор, пока по очереди не отменятся все действия и Студент не вернется к начальному состоянию.


Часть 4. Главный метод
Реализуйте консольный интерфейс для Java приложения, который будет предлагать следующий набор действий:
Создание объекта класса Студент с указанным именем. При повторном вызове действия, ранее созданные Студент идет в мусор, и в дальнейшем работа производится с этим объектом.
Добавление одной оценки объекту ранее созданного Студента.
Удаление последней оценки с указанным значением у Студента. Если такой оценки нет – ничего не происходит.
Печать текстового описания Студента на экране.

Пример выполнения:
Создан Студент Иван
Ивану добавлены оценки 5, 3 ,4
Удалена оценка 3
Студент выведен на экран. На экране окажется текст: “Иван: [5, 4]”


Часть 5. Архив
Упакуйте ранее созданное приложение в запускаемый JAR архив.

Бонусное задание: тесты 
Предоставьте в репозитории набор Junit тестов, которые тестируют корректность реализации кода для частей 1-3 задания.

