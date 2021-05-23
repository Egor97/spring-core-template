# Шаблон для практической работы по теме Spring Core

### Задание
1. В `pom.xml` добавьте зависимость `org.springframework:spring-context:5.2.1.RELEASE`. 

1. В методе main создайте новый экземпляр класса `AnnotationConfigApplicationContext` - контейнер, в котором
будут храниться ваши бины. На вход ему будет передаваться класс `MainConfiguration`. В конфигурации используйте такие
аннотации, как `@Configuration` и `@Bean`.

1. В классе `MainConfiguration` сделайте импорт двух других классов-конфигураций:
    * В классе `RepositoryConfiguration` сделайте описание бинов `ArrayListItemRepository` и `LinkedListItemRepository`
        1. В `ArrayListItemRepository` объекты `Item` должны храниться в `ArrayList` и `initialSequence` считываться из пропертей.
        1. В `ArrayListItemRepository` объекты `Item` должны храниться в `LinkedList` и `initialSequence` генерироваться случайно.
    * В классе `InitializerConfiguration` реализуйте factory-bean `ColorFactory`, который умеет выдавать сущности
     бинов `Color` по запросу `getColor`. Бин `Color` обязан создаваться каждый раз заново.

1. Имплементируйте `SimpleItemService` - сделайте так, чтобы необходимые зависимости добавлялись к нему через метод `set..`
и конструктор. В чём разница этих подходов?

1. Сделайте так, чтобы бин `ColorFactory` создавался не на этапе создания контекста, а при первом обращении к нему.
    
1. Сделайте так, чтобы используемая реализация `ItemRepository` выбиралась исходя из проперти `item.repository.implementation` 
из значений `array` или `linked`. При отсутствии проперти необходимо использовать `ArrayListItemRepository`.

1. В классе `SpringCoreTemplate` в методе `main` создайте экземпляр `ApplicationContext` и передайте ему на вход
созданный экземпляр `AnnotationConfigApplicationContext`. Сделайте парочку вызовов метода `getBean`, чтобы убедиться, 
что все бины создались и корректно работают.

1. Подключите зависимость `org.springframework:spring-test:jar:5.2.1.RELEASE`. Напишите тесты, которые проверяют основную 
бизнес-логику и то, что ваш контекст загружается успешно.