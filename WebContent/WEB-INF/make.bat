cd classes
java -Xms256M -Xmx1024M -cp ./;../lib/infirm_common.jar;../lib/mysql-connector-java-5.0.5-bin.jar;../lib/dom4j-1.6.1.jar;../lib/jtds-0.7.1.jar;../lib/ojdbc14.jar;../lib/orai18n.jar make %1 %2
cd ..