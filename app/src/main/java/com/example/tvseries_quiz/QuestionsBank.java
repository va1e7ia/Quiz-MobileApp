package com.example.tvseries_quiz;

import java.util.ArrayList;
import java.util.List;

public class QuestionsBank {

    private static List<QuestionsList> generalEruditionQuestions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Как назывался особый головной убор, который носили фараоны в Древнем Египте?",
                "Картуз", "Немес", "Корона", "Убрус",
                "Немес", "");

        final QuestionsList question2 = new QuestionsList("Какие огурцы сажал на брезентовом поле герой одноименной песни?",
                "Железные", "Оловянные", "Медные", "Алюминиевые",
                "Алюминиевые", "");

        final QuestionsList question3 = new QuestionsList("У какого животного самые большие глаза относительно тела?",
                "У лемура", "У летучей мыши", "У долгопята", "У тупайи",
                "У долгопята", "");

        final QuestionsList question4 = new QuestionsList("Детинцем на Руси называли...",
                "Кремль", "Школу", "Княжеский терем", "Монастырь",
                "Кремль", "");

        final QuestionsList question5 = new QuestionsList("Как называли строителя в старину?",
                "Бондарь", "Бортник", "Зодчий", "Кормчий",
                "Зодчий", "");

        final QuestionsList question6 = new QuestionsList("Продолжите пословицу: «Знает кошка…»",
                "«Да мыши не знают»", "«Почем фунт лиха»", "«Где собака зарыта»", "«Чье мясо съела»",
                "«Чье мясо съела»", "");

        final QuestionsList question7 = new QuestionsList("Какое из этих растений — плотоядное?",
                "Володушка", "Росянка", "Мытник", "Астрагал",
                "Росянка", "");

        final QuestionsList question8 = new QuestionsList("Как называется человек, покоряющий крыши многоэтажных домов?",
                "Диггер", "Сталкер", "Руфер", "Байкер",
                "Руфер", "");

        final QuestionsList question9 = new QuestionsList("Какая пряность по форме напоминает звездочку?",
                "Майоран", "Кардамон", "Гвоздика", "Бадьян",
                "Бадьян", "");

        final QuestionsList question10 = new QuestionsList("Сколько лет проходит между ситцевой и золотой свадьбой?",
                "11", "19", "25", "49",
                "49", "");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> filmQuestions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Какой фильм стал первым полнометражным анимационным фильмом Disney?",
                "\"Золушка\"", "\"Спящая красавица\"", "\"Белоснежка и семь гномов\"", "\"Пиноккио\"",
                "\"Белоснежка и семь гномов\"", "");

        final QuestionsList question2 = new QuestionsList("Какой актер сыграл роль Джеймса Бонда в фильме \"Casino Royale\" (2006)?",
                "Пирс Броснан", "Дэниел Крейг", "Шон Коннери", "Тимоти Далтон",
                "Дэниел Крейг", "");

        final QuestionsList question3 = new QuestionsList("Какой сериал о группе друзей, живущих в Нью-Йорке, стал культовым в 1990-х?",
                "\"Друзья\"", "\"Как я встретил вашу маму\"", "\"Секс в большом городе\"", "\"Семейные узы\"",
                "\"Друзья\"", "");

        final QuestionsList question4 = new QuestionsList("Какой фильм получил Оскар за лучший фильм в 2020 году?",
                "\"1917\"", "\"Паразиты\"", "\"Джокер\"", "\"Ford против Ferrari\"",
                "\"Паразиты\"", "");

        final QuestionsList question5 = new QuestionsList("Какой фильм о вампирах, вышедший в 1994 году, был снят по роману Энн Райс?",
                "\"Сумерки\"", "\"Интервью с вампиром\"", "\"Дракула\"", "\"Вампиры\"",
                "\"Интервью с вампиром\"", "");

        final QuestionsList question6 = new QuestionsList("Как зовут персонажа, которого играет Крис Хемсворт в фильмах Marvel?",
                "Тони Старк", "Капитан Америка", "Тор", "Халк",
                "Тор", "");

        final QuestionsList question7 = new QuestionsList("Кто создал знаменитый мультсериал \"Симпсоны\"?",
                "Сет Макфарлейн", "Мэтт Грейнинг", "Трей Паркер", "Дэн Хармона",
                "Мэтт Грейнинг", "");

        final QuestionsList question8 = new QuestionsList("Какой актер сыграл роль Уолтера Уайта в сериале \"Во все тяжкие\"?",
                "Брайан Кранстон", "Аррон Пол", "Алек Болдуин", "Джон Хамм",
                "Брайан Кранстон", "");

        final QuestionsList question9 = new QuestionsList("Какой фильм рассказывает о дружбе между мальчиком и инопланетянином?",
                "\"Пришельцы\"", "\"Супермен\"", "\"Э.Т. Инопланетянин\"", "\"Контакт\"",
                "\"Э.Т. Инопланетянин\"", "");

        final QuestionsList question10 = new QuestionsList("Какой российский сериал рассказывает о группе заключенных в тюрьме?",
                "\"Бригада\"", "\"Универ\"", "\"Закрытая школа\"", "\"Операция 'Ы' и другие приключения Шурика\"",
                "\"Бригада\"", "");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> musicQuestions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Какой британский рок-группы был вокалистом Фредди Меркьюри?",
                "The Beatles", "Led Zeppelin", "Queen", "The Rolling Stones",
                "Queen", "");

        final QuestionsList question2 = new QuestionsList("Какой альбом Майкла Джексона стал самым продаваемым альбомом всех времен?",
                "\"Thriller\"", "\"Bad\"", "\"Dangerous\"", "\"Off the Wall\"",
                "\"Thriller\"", "");

        final QuestionsList question3 = new QuestionsList("Кто написал знаменитую песню \"Imagine\"?",
                "Пол Маккартни", "Джон Леннон", "Боб Дилан", "Элтон Джон",
                "Джон Леннон", "");

        final QuestionsList question4 = new QuestionsList("Какой стиль музыки ассоциируется с городом Новый Орлеан и включает в себя элементы джаза и блюза?",
                "Рок", "Соул", "Фонк", "Дикси",
                "Дикси", "");

        final QuestionsList question5 = new QuestionsList("Какая группа выпустила хит \"Hotel California\"?",
                "The Eagles", "Fleetwood Mac", "Lynyrd Skynyrd", "The Doors",
                "The Eagles", "");

        final QuestionsList question6 = new QuestionsList("Какой певец известен как \"Король поп-музыки\"?",
                "Элвис Пресли", "Майкл Джексон", "Принс", "Джастин Тимберлейк",
                "Майкл Джексон", "");

        final QuestionsList question7 = new QuestionsList("Какой музыкальный фестиваль проходит в Гластонбери, Великобритания?",
                "Coachella", "Glastonbury Festival", "Lollapalooza", "Woodstock",
                "Glastonbury Festival", "");

        final QuestionsList question8 = new QuestionsList("Какой жанр музыки был популярен в 1980-е годы и включает в себя синтезаторы и электронные инструменты?",
                "Хип-хоп", "Диско", "Новая волна", "Гранж",
                "Новая волна", "");

        final QuestionsList question9 = new QuestionsList("Кто из следующего является известным рэп-исполнителем и продюсером, основателем лейбла Roc-A-Fella Records?",
                "50 Cent", "Jay-Z", "Eminem", "Snoop Dogg",
                "Jay-Z", "");

        final QuestionsList question10 = new QuestionsList("Какой музыкальный инструмент является символом классической музыки и часто используется в симфонических оркестрах?",
                "Гитара", "Фортепиано", "Скрипка", "Ударные",
                "Скрипка", "");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    private static List<QuestionsList> geographyQuestions() {

        final List<QuestionsList> questionsList = new ArrayList<>();

        final QuestionsList question1 = new QuestionsList("Какой самый большой океан на Земле?",
                "Атлантический", "Индийский", "Тихий", "Северный Ледовитый",
                "Тихий", "");

        final QuestionsList question2 = new QuestionsList("В какой стране находится гора Эверест?",
                "Индия", "Непал", "Китай", "Бутан",
                "Непал", "");

        final QuestionsList question3 = new QuestionsList("Какой континент является родиной пингвинов?",
                "Австралия", "Антарктида", "Южная Америка", "Африка",
                "Антарктида", "");

        final QuestionsList question4 = new QuestionsList("Какое государство имеет наибольшее количество соседей?",
                "Россия", "Бразилия", "Китай", "Индия",
                "Китай", "");

        final QuestionsList question5 = new QuestionsList("Какой город является столицей Японии?",
                "Осака", "Токио", "Киото", "Хиросима",
                "Токио", "");

        final QuestionsList question6 = new QuestionsList("Какое море считается самым соленым на планете?",
                "Красное", "Балтийское", "Мертвое", "Карибское",
                "Мертвое", "");

        final QuestionsList question7 = new QuestionsList("Какой остров крупнейший в мире?",
                "Гренландия", "Новая Гвинея", "Борнео", "Мадагаскар",
                "Гренландия", "");

        final QuestionsList question8 = new QuestionsList("Какая река является самой длинной в мире?",
                "Нил", "Амазонка", "Янцзы", "Миссисипи",
                "Амазонка", "");

        final QuestionsList question9 = new QuestionsList("Какая пустыня является самой большой в мире?",
                "Сахара", "Гоби", "Калахари", "Атакама",
                "Сахара", "");

        final QuestionsList question10 = new QuestionsList("Какой город расположен на двух континентах?",
                "Москва", "Стамбул", "Каир", "Тбилиси",
                "Стамбул", "");


        questionsList.add(question1);
        questionsList.add(question2);
        questionsList.add(question3);
        questionsList.add(question4);
        questionsList.add(question5);
        questionsList.add(question6);
        questionsList.add(question7);
        questionsList.add(question8);
        questionsList.add(question9);
        questionsList.add(question10);
        return questionsList;
    }

    public static List<QuestionsList> qetQuestions (String selectedTopicName){
        switch(selectedTopicName){
            case "generalErudition": return generalEruditionQuestions();
            case "film": return filmQuestions();
            case "music": return musicQuestions();
            default: return geographyQuestions();
        }
    }

}
