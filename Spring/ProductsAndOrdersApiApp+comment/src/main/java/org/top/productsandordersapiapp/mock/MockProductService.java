package org.top.productsandordersapiapp.mock; //пакет

import org.springframework.stereotype.Service; // импорт сервиса
import org.top.productsandordersapiapp.entity.Product; // импорт класса
import org.top.productsandordersapiapp.service.ProductService; // импорт интерфейса

import java.util.ArrayList; // импорт коллекции
import java.util.List;      // импорт коллекции
import java.util.Optional;  // импорт optional

@Service // аннотация service, используется во внедрении зависимости
public class MockProductService implements ProductService { //класс - заглушка, имитация работы с бд, расширяет интерфейс ProductService, реализует его методы

    private static final List<Product> products = new ArrayList<>(); // поле со списком
    private static Integer nextId = 1; // поле искусственного id

    //метод получения всех продуктов
    @Override                               // аннотация переопределения
    public List<Product> getAll() {         //метод, ничего не принимает,
        return new ArrayList<>(products); //возвращает новый список продуктов, копию
    }

    //метод получения продукта по id
    @Override                                       // аннотация переопределения
    public Optional<Product> getById(Integer id) {  // метод, принимает id, возвращает optional
        // return products.stream().filter(p -> Objects.equals(p.getId(), id)).findFirst();
        for (Product product : products) { // foreach проходим по списку продуктов
            if (product.getId().equals(id)) { //если id продукта равен id, который прилетел параметром
                return Optional.of(product); //возвращается optional продукта
            }
        }
        return Optional.empty(); // иначе возвращаем пустой optional
    }

    //метод добавления продукта
    @Override                                       // аннотация переопределения
    public Product add(Product product) {           // Метод, принимает Product, возвращает Product
        product.setId(nextId++);                    // через сеттер устанавливаем id продукта, инкремент id
        products.add(product);                      // добавляем продукт в список
        return product;                             // возвращаем продукт
    }

    //метод удаления продукта по id
    @Override                                        // аннотация переопределения
    public Boolean deleteById(Integer id) {         // Метод, принимает id, возвращает true если удалил, false если нет
        Optional<Product> deleted = getById(id);    // получаем продукт через метод getById(id), реализованный выше
        deleted.ifPresent(products::remove);        // если такой продукт есть в списке, то он удаляется
        return deleted.isPresent();                 // возвращается true если продукт существует, false если нет
    }

    //метод обновления продукта
    @Override                                                        // аннотация переопределения
    public Optional<Product> update(Product product) {              // Метод, принимает Product, возвращает optional
        Optional<Product> updated = getById(product.getId());       //получаем optional продукта через метод getById
        if (updated.isEmpty()) {                                    //если такого продукта нет, updated пустой
            return Optional.empty();                                // возвращаем пустой optional
        }
        // если объект найден
        updated.get().setTitle(product.getTitle()); // через сеттер устанавливаем значение в поле title, значение берем из продукта через геттер
        updated.get().setPrice(product.getPrice());// через сеттер устанавливаем значение в поле price, значение берем из продукта через геттер
        updated.get().setQuantity(product.getQuantity());// через сеттер устанавливаем значение в поле quantity, значение берем из продукта через геттер
        updated.get().setDescription(product.getDescription());// через сеттер устанавливаем значение в поле description, значение берем из продукта через геттер
        //
        return updated; //возвращаем optional обновленного объекта
    }
}
