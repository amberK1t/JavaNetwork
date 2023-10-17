package org.top.productsandordersapiapp.rdb; // пакет

import org.springframework.stereotype.Service; // импорт сервиса
import org.top.productsandordersapiapp.entity.Product; // импорт класса
import org.top.productsandordersapiapp.service.ProductService; // импорт интерфейса

import java.util.List; // импорт коллекции
import java.util.Optional; // импорт optional

@Service // аннотация сервиса, используется spring для инъекции зависимости
public class RdbProductService implements ProductService { // класс-сервис расширяет интерфейс ProductService, реализует его методы

    // внедрение репозиторий в имплементацию сервиса через DI
    private final ProductRepository productRepository; // поле репозитория

    public RdbProductService(ProductRepository productRepository) { // использование конструктора в DI
        this.productRepository = productRepository;                 // присвоение поля
    }

    @Override                                                       // аннотация переопределения
    public List<Product> getAll() {                                 // Метод получения списка продуктов, ничего не принимает, возвращает коллекцию
        return (List<Product>)productRepository.findAll();          // используем метод интерфейса, который наследуется от CrudRepository,
                                                                    // кастим в лист продуктов, возвращаем
    }

    @Override                                                       // аннотация переопределения
    public Optional<Product> getById(Integer id) {                  // метод поиска по id, принимает id, возвращает optional
        return productRepository.findById(id);                      // возвращаем результат метода интерфейса
    }

    @Override                                                       // аннотация переопределения
    public Product add(Product product) {                           // метод добавления продукта, принимает Product, возвращает Product
        return productRepository.save(product);                     // возвращаем результат метода интерфейса
    }

    @Override                                                       // аннотация переопределения
    public Boolean deleteById(Integer id) {                         // метод удаления продукта, принимает id, возвращает true если удалил, false если нет
        Optional<Product> deleted = productRepository.findById(id); // получаем optional через метод интерфейса поиска по id
        if (deleted.isPresent()) {                                  // если такой продукт есть
            productRepository.deleteById(id);                       // удаляем
        }
        return deleted.isPresent();                                 // возвращаем true, если объект был найден по id, false если нет
    }

    @Override                                                       // аннотация переопределения
    public Optional<Product> update(Product product) {              // метод обновления продукта, принимает Product, возвращает optional
        Optional<Product> updated = productRepository.findById(product.getId()); //ищем по id, присваиваем optional
        if (updated.isPresent()) {                                  // если такой продукт найден
            productRepository.save(product);                        // сохраняем, перезаписываем product
            return Optional.of(product);                            // возвращаем optional этого продукта
        }
        return Optional.empty();                                    // иначе возвращаем пустой optional
    }
}
