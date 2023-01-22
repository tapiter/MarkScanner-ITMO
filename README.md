# MarkScanner
MarkScanner - неофициальное приложение для проверки кодов маркировки

## Возможности
* Сканирование (в том числе инвертированных) кодов
* Ручной ввод КМ или КИ (для некоторых товарных групп)

<details>
  <summary>Скриншот</summary>

![image](https://user-images.githubusercontent.com/13136992/213932720-0a17f113-ddb5-4c5a-960c-0f5d8b7f5c8f.png)
</details>

* Получение основных статусов

<details>
  <summary>Скриншот</summary>

![image](https://user-images.githubusercontent.com/13136992/213932766-52033be9-6af2-443a-8503-ae873dddaf63.png)
</details>

* Просмотр ответа от сервера в формате JSON со всеми атрибутами

<details>
  <summary>Скриншот</summary>

![image](https://user-images.githubusercontent.com/13136992/213932913-38760637-3a48-40fd-bfe2-aa1a63ffed35.png)
</details>

* История сканирования с возможностью обновления

<details>
  <summary>Скриншот</summary>

![image](https://user-images.githubusercontent.com/13136992/213932847-e5ce1025-02b1-44d8-bfbb-0855ddebcc56.png)
</details>

* Поддержка мобильного API ЦРПТ (как и в приложении ЧЗ) или Trye-API с возможностью получения токена с URL

<details>
  <summary>Скриншот</summary>

![image](https://user-images.githubusercontent.com/13136992/213932970-5ef61cbf-0503-4d36-b354-551e035a7254.png)
</details>

* Поддерживается на Android 8.0 (SDK 26) и выше

## Используемые библиотеки:

- AndroidX
- CameraX для работы с камерой
- Google ML Kit для сканирования штрихкодов
- Room для работы с SQLite БД
- OkHttp для выполнения HTTP запросов
- Gson для работы с JSON
- Android JSON Viewer для компонента просмотра JSON
- Google Material 3 Components для стилизации
- SharedPreferences для хранения настроек приложения

## Структура

Проект реализован по паттерну Single Activity с использованием Fragments и навигацией через supportFragmentManager.  
Верстка фрагментов осуществляется через XML layouts с ViewBinding.  

- В корневом пакете находятся классы Activities
- В пакете **fragments** находятся фрагменты
- В пакете **db** находятся классы для работы с БД Room
