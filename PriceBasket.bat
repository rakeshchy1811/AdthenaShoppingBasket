@echo off
chcp 65001 >NUL
java -jar target\scala-3.3.1\ShoppingBasket-assembly-1.0.jar %*
