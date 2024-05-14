package tr.edu.medipol.ygaoweb;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebService {

    public record Ogrenci(String id, String name) {
    }
    private static List<Ogrenci> OGRENCILER = new ArrayList<>();
    static {
        OGRENCILER.add(new Ogrenci("1", "Berk"));
        OGRENCILER.add(new Ogrenci("2", "Esma"));
    }

    @GetMapping()
    public List<Ogrenci> list(){
        return OGRENCILER;
    }

    @PostMapping()
    public void OgrenciEkle(Ogrenci yeniOgrenci) {
        OGRENCILER.add(yeniOgrenci);
    }

    @DeleteMapping()
    public boolean sil(@RequestParam String id) {
        for (Ogrenci ogrenci: OGRENCILER) {
            if (!ogrenci.id.equals(id)) {
                continue;
            }
            OGRENCILER.remove(ogrenci);
            return true;
        }
        return false;
    }
}
