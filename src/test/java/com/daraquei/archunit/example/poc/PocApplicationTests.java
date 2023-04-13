package com.daraquei.archunit.example.poc;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;

class PocApplicationTests {

	@Test
	void checkControllerClassDependencies_pass() {
       JavaClasses jc = new ClassFileImporter().importPackages("com.daraquei.archunit.example.poc");
        
        ArchRule r1 = classes()
          .that()
          .resideInAPackage("..controller..")
          .should().onlyDependOnClassesThat()
          .resideInAnyPackage("..service..", "org.springframework..", "java.lang..");
        r1.check(jc);
        
	}
	
	@Test
	void checkControllerClassDependencies_fail() {
       JavaClasses jc = new ClassFileImporter().importPackages("com.daraquei.archunit.example.poc");
        
        ArchRule r1 = classes()
          .that()
          .resideInAPackage("..controller..")
          .should().onlyDependOnClassesThat()
          .resideInAnyPackage("..repository..", "org.springframework..", "java.lang..");
        assertThrows(AssertionError.class, ()-> r1.check(jc)) ;
	}
	
	@Test
	void checkServiceClassDependencies_pass() {
     JavaClasses jc = new ClassFileImporter().importPackages("com.daraquei.archunit.example.poc");
        
        ArchRule r1 = classes()
          .that()
          .resideInAPackage("..service..")
          .should().onlyDependOnClassesThat()
          .resideInAnyPackage("..repository..", "org.springframework..", "java.lang..");
        r1.check(jc);
	}
	
	@Test
	void checkServiceClassDependencies_fail() {
     JavaClasses jc = new ClassFileImporter().importPackages("com.daraquei.archunit.example.poc");
        
        ArchRule r1 = classes()
          .that()
          .resideInAPackage("..service..")
          .should().onlyDependOnClassesThat()
          .resideInAnyPackage("..controller..", "org.springframework..", "java.lang..");
        assertThrows(AssertionError.class, ()-> r1.check(jc)) ;
	}

}
