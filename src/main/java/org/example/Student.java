package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.Stack;

public class Student {
    private String name; // имя студента
    private List<Object> grades; // оценки
    private Predicate<Object> isGradeValid; // Предик для проверки правильности оценки

    private Stack<Action> actionStack; // Стек для хранения действий

    // Конструкторы:
    // Создание студента с указанием имени
    // Создание студента с указанием имени и оценок
    public Student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.actionStack = new Stack<>();
        this.isGradeValid = is -> (true);
    }

    public Student(String name, List<Object> grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
        this.actionStack = new Stack<>();
        this.isGradeValid = is -> (true);
    }

    public Student(String name, Predicate<Object> isGradeValid) {
        this.name = name;
        this.grades = new ArrayList<>();
        this.isGradeValid = isGradeValid;
        this.actionStack = new Stack<>();
    }

    public Student(String name, List<Object> grades, Predicate<Object> isGradeValid) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
        this.isGradeValid = isGradeValid;
        this.actionStack = new Stack<>();
    }

    // Метод для получения имени
    public String getName() {
        return name;
    }

    // Метод для установки нового имени
    public void setName(String name) {
        Action action = new Action(ActionType.NAME_CHANGE, this.name);
        this.name = name;
        actionStack.push(action);
    }

    // Метод для получения оценок
    public List<Object> getGrades() {
        return grades;
    }

    // Метод для добавления оценки
    public void addGrade(Object grade) {
        if (isGradeValid.test(grade)) {
            this.grades.add(grade);
            Action action = new Action(ActionType.GRADE_ADD, grade);
            actionStack.push(action);
        } else {
            throw new IllegalArgumentException("Invalid grade");
        }
    }

    // Метод для удаления конткретной оценки
    public void removeGrade(Object grade) {
        if (grades.contains(grade)) {
            this.grades.remove(grade);
            Action action = new Action(ActionType.GRADE_REMOVE, grade);
            actionStack.push(action);
        }
    }

    // Метод Отмены:
    // Использован Стек-Действий, куда записываем
    // последовательно действия выполненные над студентом, а именно:
    // Изменение имени || Добавление/оценки
    // Останавливаемся на состание, когда создался студент
    public void undoLastAction() {
        if (!actionStack.isEmpty()) {
            Action lastAction = actionStack.pop();
            if (lastAction.getType() == ActionType.NAME_CHANGE) {
                this.name = (String) lastAction.getData();
            } else if (lastAction.getType() == ActionType.GRADE_ADD) {
                this.grades.remove(lastAction.getData());
            } else if (lastAction.getType() == ActionType.GRADE_REMOVE) {
                this.grades.add(lastAction.getData());
            }
        }
    }

    // Проверка на равность студентов:
    // Два Студента равны если у них одинаковые имена и список оценок
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grades);
    }

    // Текстовое представление студента имеет вид: “Имя: [оценка1, оценка2,…,оценкаN]”
    @Override
    public String toString() {
        return name + ": " + grades;
    }

    private enum ActionType {
        NAME_CHANGE, GRADE_ADD, GRADE_REMOVE
    }

    private static class Action {
        private ActionType type;
        private Object data;

        public Action(ActionType type, Object data) {
            this.type = type;
            this.data = data;
        }

        public ActionType getType() {
            return type;
        }

        public Object getData() {
            return data;
        }
    }
}
