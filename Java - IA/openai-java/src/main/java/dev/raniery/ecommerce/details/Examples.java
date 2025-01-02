package dev.raniery.ecommerce.details;

public class Examples {

    public static String getExamples() {
        return """
            Use example:
            question: I like to read programming books
            answer: 1. Clean Code by Robert C. Martin
            2. The Pragmatic Programmer by Andrew Hunt and David Thomas
            3. Refactoring by Martin Fowler
            4. Design Patterns by Erich Gamma, Richard Helm, Ralph Johnson, and John Vlissides
            
            question: I want some new athletic shoes
            answer: 1. Nike Air Zoom Pegasus 38
            2. Adidas Ultraboost 21
            3. New Balance Fresh Foam 1080v11
            4. Brooks Ghost 13
            5. Hoka One One Clifton 7
            
            question: skincare products
            answer: 1. CeraVe Hydrating Facial Cleanser
            2. Neutrogena Hydro Boost Gel-Cream
            3. Neutrogena Ultra Sheer Dry-Touch Sunscreen SPF 55
            4. CeraVe Moisturizing Cream
            
            question: some pajamas
            answer: 1. Ekouaer Pajamas Set
            2. PajamaGram Pajama Set
            3. Alexander Del Rossa Pajama Set
            """;
    }

    public static String getExamplesRules() {
        return """
            example:
            question:
            cliente0,"Óculos de Sol SunStyle, Creme Hidratante ExtraSoft, Tapete ZenComfort, Pelúcia CuteTeddyBear, Kit de Toalhas SoftLux, Love in the City, Almofada Decorativa CushyStyle, Moto Esportiva SpeedMaster"
            cliente1,"Bolsa Feminina FashionLady, Loção Corporal BodyFresh, Creme Hidratante ExtraSoft, Anel de Noivado EternalLove, Corda de Pular JumpFit, Fitness, Luvas de Boxe FightMaster, Kit de Pintura ArtMaster"
            cliente2,"Romance Amor Proibido, Relógio de Parede VintageClock, Vinho Tinto ClassicRed, Carregador Portátil PowerGo, Escova Dental Elétrica CleanTeeth, Refrigerante SparklingFizz, Conjunto de Jóias SparkleSet, Filme de Ação ActionForce"
            answer:
            cliente0: Beach towel
            cliente1: Ring EternalLove
            cliente2: Amazon Kindle
            """;
    }
}
