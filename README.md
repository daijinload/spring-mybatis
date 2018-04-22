# spring-mybatisテスト

このプロジェクトは、Java8 Spring-MVC4 Mybatis3 Junit5で動かしています。

junitチームが公開している [junit5-vanilla-gradle](https://github.com/junit-team/junit5-samples/tree/master/junit5-vanilla-gradle) プロジェクトがベースとなっています。

テスト実行が２秒を切ることを目標に作成してます。

mavenベースのプロジェクトでも良かったのですが、gradleベースのほうが手元のマシンで実行速度が
良かったためgradleベースを採用しました。

# require

- Java8
- MariaDB(MySQLでやりたい場合、ドライバとコンフィグの修正が必要です。)
- Gradle4.6

## table

```
create database aaa;
use aaa;
create table test (
  `id` int unsigned not null auto_increment comment 'プライマリキーだよ',
  `c1` varchar(255) not null default 'hoge' comment 'テキストいれるとこだよ',
  `c2` text,
  `c3` tinyint,
  `c4` smallint,
  `c5` int,
  `c6` bigint,
  `c7` datetime,
  `c8` timestamp,
  primary key(`id`)
) engine=innodb default charset=utf8 comment 'このテーブルはテストテーブル';
insert into test (c1, c2, c3, c4, c5, c6, c7) values ('hello!!', '2', 3, 4, 5, 6, '2018-02-04');
insert into test (c1, c2, c3, c4, c5, c6, c7) values ('hello!!222', '2', 3, 4, 5, 6, '2018-02-04');
insert into test (c1, c2, c3, c4, c5, c6, c7) values ('hello!!333', '2', 3, 4, 5, 6, '2018-02-04');
```

## run

```
./gradlew clean test
or
./gradlew test
```

# options

## google-java-format

googleのフォーマッタを使っています。インデントが2スペースで微妙ですが、無いよりはマシと、とりあえずつかっています。

```
cd プロジェクトroot
wget https://github.com/google/google-java-format/releases/download/google-java-format-1.5/google-java-format-1.5-all-deps.jar
find . -name "*.java" | xargs java -jar ./google-java-format-1.5-all-deps.jar --replace
or
git diff --name-only | fgrep .java | xargs java -jar ./google-java-format-1.5-all-deps.jar --replace
```

## spotbugs

静的チェッカー。見やすいほうで良いが、個人的にはtxtファイルのほうが見やすい。catでも見れるしね。

```
cd プロジェクトroot
wget http://repo.maven.apache.org/maven2/com/github/spotbugs/spotbugs/3.1.3/spotbugs-3.1.3.zip
unzip spotbugs-3.1.3.zip
mkdir -p build/reports/spotbugs
java -jar ./spotbugs-3.1.3/lib/spotbugs.jar -textui -effort:max -output build/reports/spotbugs/report.txt build/classes/
cat ./build/reports/spotbugs/report.txt 
or
java -jar ./spotbugs-3.1.3/lib/spotbugs.jar -textui -effort:max -output spotbugs-report.html -html build/classes/
```

## jacoco

コードカバレッジツール

```
gradle jacoco
# output -> build/reports/jacoco/html/index.html
```
