package org.top.productsandordersapiapp.entity; //пакет

import jakarta.persistence.*;  //необходимые импорты для аннотаций

// Класс Product - описывает объект товара,
// соответствует таблицы product_t из БД
// хранить информацию об объекте "Товар", не реализует бизнес-логику,
// является dataclass-ом
@Entity //аннотация сущности, помечает класс как сущность
@Table(name = "product_t") //аннотация таблица, связь с именем таблицы из бд
public class Product { // класс
    // поля - соответствуют столбцам (атрибутам) таблице в БД
    @Id                                                 // аннотация id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // аннотация инкремента id
    private Integer id;                                 // private поле id

    @Column(name="title_f", nullable = false)  //аннотация колонки, столбца, связь с именем столбца из бд, не может быть null
    private String title;                       // private поле названия продукта

    @Column(name="price_f", nullable = false)   //аннотация колонки, столбца, связь с именем столбца из бд, не может быть null
    private Double price;                       // private поле цены продукта

    @Column(name="quantity_f", nullable = false) //аннотация колонки, столбца, связь с именем столбца из бд, не может быть null
    private Integer quantity;                     // private поле количества продукта

    @Column(name="description_f")               //аннотация колонки, столбца, связь с именем столбца из бд
    private String description;                 // private поле описания продукта, может быть пустым

    // constructors

    // 1. конструктор по умолчанию
    public Product() { //конструктор по умолчанию
        id = 0;         //присвоение
        title = "";     //переменным
        price = 0.0;    //значения
        quantity = 0;   // по
        description = null; // умолчанию))
    }

    // getters & setters

    public Integer getId() {
        return id;
    } //геттер id, ничего не принимает, возвращает id

    public void setId(Integer id) {
        this.id = id;
    } // сеттер id, принимает Integer, устанавливает это значение в поле id

    public String getTitle() {
        return title;
    } //геттер title, ничего не принимает, возвращает title

    public void setTitle(String title) {
        this.title = title;
    } // сеттер title, принимает строку, устанавливает это значение в title

    public Double getPrice() {
        return price;
    } //геттер price, ничего не принимает, возвращает price

    public void setPrice(Double price) {
        this.price = price;
    } // сеттер price, принимает Double, устанавливает это значение в price

    public Integer getQuantity() {
        return quantity;
    } //геттер quantity, ничего не принимает, возвращает quantity

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    } // сеттер quantity, принимает Integer, устанавливает это значение в quantity

    public String getDescription() {
        return description;
    } //геттер description, ничего не принимает, возвращает description

    public void setDescription(String description) {
        this.description = description;
    } // сеттер description, принимает строку, устанавливает это значение в description
    // Spring создает сущность конструктором по умолчанию, используя геттеры и сеттеры, получает и устанавливает значения полей
    // также геттеры и сеттеры используются в моке, заглушке

    // представление объекта в виде строки
    @Override // аннотация переопределения метода
    public String toString() { // переопределяем тустринг, представление объекта в виде удобной строки, а не ссылки
        // Product(id=1,title="test",price=1000,quantity=100,description=null)
        // toString() -> "1 - test - 1000 - 100 - null"
        return id + " - " + title + " - " + price + " - " + quantity + " - " + description; //возвращаем строку
    } //скобатька
}       //скобатька

