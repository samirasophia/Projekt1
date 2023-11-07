import org.example.Projekt1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
public class Projekt1_Test {
        @Test
        void Passwordtest(){
            //GIVEN
            String password = "meow123K";
                    int laenge = 8;

            int i = 0;
            String [] usedPasswords = new String[i];
            //WHEN
            boolean actual = Projekt1.prüfer(laenge, password, usedPasswords);

            //THEN
          assertFalse(actual);
        }
}

