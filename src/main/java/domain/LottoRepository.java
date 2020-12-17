package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRepository {

    private static final List<Lotto> lottos = new ArrayList<>();

    public static List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public static void add(Lotto lotto) {
        lottos.add(lotto);
    }

}
