CREATE DATABASE Restaurante;
USE Restaurante;
SET SQL_SAFE_UPDATES = 0;

CREATE TABLE Item (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  `categoria` ENUM('comida', 'bebida', 'sobremesa') NOT NULL,
  `preco` DECIMAL(10,2) NOT NULL,
  `status` TINYINT(1) NOT NULL DEFAULT 1 COMMENT '1 = disponível, 0 = indisponível',
  `qtdEstoque` INT NOT NULL DEFAULT 0,
  `imagem` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE Carrinho (
  `id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
);

CREATE TABLE Pedido (
  id INT NOT NULL AUTO_INCREMENT,
  valorTotal DECIMAL(10,2) NOT NULL,
  idCarrinho INT NOT NULL,
  uuidCliente VARCHAR(36),
  status VARCHAR(20) DEFAULT 'Em andamento',
  PRIMARY KEY (id),
  CONSTRAINT fk_pedido_carrinho
    FOREIGN KEY (idCarrinho)
    REFERENCES Carrinho(id)
);

CREATE TABLE ItemCarrinho (
  `itemCarrinhoId` INT NOT NULL AUTO_INCREMENT,
  `idItem` INT UNSIGNED NOT NULL,
  `idCarrinho` INT NOT NULL,
  `qtdItem` INT NOT NULL,
  PRIMARY KEY (`itemCarrinhoId`),
  CONSTRAINT `fk_Item_Carrinho_ItemId`
    FOREIGN KEY (`idItem`)
    REFERENCES `Item` (`id`),
  CONSTRAINT `fk_Item_Carrinho_CarrinhoId`
    FOREIGN KEY (`idCarrinho`)
    REFERENCES `Carrinho` (`id`)
);

ALTER TABLE itemcarrinho
DROP FOREIGN KEY fk_Item_Carrinho_ItemId;

ALTER TABLE itemcarrinho
ADD CONSTRAINT fk_Item_Carrinho_ItemId
FOREIGN KEY (idItem) REFERENCES item(id)
ON DELETE CASCADE;
