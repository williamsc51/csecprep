package io.cxcprep.entities;

public enum Subjects {
    MATHEMATICS("mathematics"),
    ENGLISH("english"),
    PHYSICS("physics"),
    BIOLOGY("biology"),
    CHEMISTRY("chemistry"),
    INFORMATION_TECHNOLOGY("information_technology"),
    PRINCIPLES_OF_ACCOUNTS("principles_of_accounts"),
    PRINCIPLES_OF_BUSINESS("principles_of_business"),
    ECONOMICS("economics"),
    CARIBBEAN_HISTORY("history"),
    SOCIAL_STUDIES("social_studies"),
    SPANISH("spanish"),
    TECHNICAL_DRAWING("technical_drawing"),
    FRENCH("french"),
    FOOD_AND_NUTRITION("food_and_nutrition");

    private final String subject;

    Subjects(String subject){
        this.subject = subject;
    }

    public String getSubject(){
        return this.subject;
    }
}

/*
AGRICULTURAL SCIENCE SA
BIOLOGY
CARIBBEAN HISTORY
CHEMISTRY
ECONOMICS
ELECTRONIC DOCUMENT PREPARATION AND MANAGEMENT
ENGLISH
FAMILY AND RESOURCE MANAGEMENT
FOOD NUTRITION AND HEALTH
FRENCH
GEOGRAPHY
HUMAN AND SOCIAL BIOLOGY
INDUSTRIAL TECHNOLOGY - BUILDING
INDUSTRIAL TECHNOLOGY - ELECTRICAL
INDUSTRIAL TECHNOLOGY - MECHANICAL
INFORMATION TECHNOLOGY
MATHEMATICS
MUSIC
PHYSICAL EDUCATION AND SPORT
PHYSICS
PRINCIPLES OF ACCOUNTS
PRINCIPLES OF BUSINESS
RELIGIOUS EDUCATION
SOCIAL STUDIES
SPANISH
TECHNICAL DRAWING
TEXTILES CLOTHING AND FASHION
THEATRE ARTS
VISUAL ARTS
*/