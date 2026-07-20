-- Посты (без изменений)
INSERT INTO posts (title, content, image, createdat)
VALUES
  ('Привет, мир!', 'Это мой первый пост. Добро пожаловать на сайт!', NULL, '2026-07-13T12:00:00Z'),
  ('Как я начал программировать', 'Краткая история моего пути в IT.', NULL, '2026-07-13T12:30:00Z'),
  ('Мой любимый инструмент', 'Рассказываю про IntelliJ IDEA и почему он лучший.', NULL, '2026-07-13T13:00:00Z');

-- Проекты (исправлено)
INSERT INTO projects (name, description, techstack, url)
VALUES
  ('Личный сайт', 'Бекенд на Spring Boot и Java, фронтенд на GitHub Pages. CI/CD, REST API, H2/PostgreSQL.', 'Java, Spring Boot, H2, PostgreSQL, HTML, CSS, JavaScript', 'https://github.com/isthisalis/personal-backend'),
  ('Telegram Bot', 'Бот для учета личных расходов. Умеет парсить чеки, строить графики.', 'Python, Aiogram, PostgreSQL, Docker', 'https://github.com/isthisalis/expenses-bot');

-- О себе (исправлено)
INSERT INTO about (title, content, techstack)
VALUES (
  'Привет! Меня зовут Алишер.',
  'Я Java-разработчик, увлекаюсь бекендом и автоматизацией. Сейчас активно изучаю Spring Boot и GitHub Actions.\n\nВ свободное время пишу пет-проекты, читаю и катаюсь на велосипеде.\n\nЭтот сайт — мой учебный проект, который я сделал полностью сам: от бекенда до деплоя.',
  'Java, Spring Boot, PostgreSQL, Docker, GitHub Actions'
);
