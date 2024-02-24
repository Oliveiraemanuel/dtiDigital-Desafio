package service;

import domains.Alimento;
import domains.enums.GrupoAlimento;

import java.util.*;

public class AlimentoService {

    private static List<Alimento> alimentos = new ArrayList<>() {{
        // caloria por 100 gramas
        add(new Alimento("Arroz", GrupoAlimento.CARBOIDRATO, 130));
        add(new Alimento("Macarrão", GrupoAlimento.CARBOIDRATO, 150));
        add(new Alimento("Batata Doce", GrupoAlimento.CARBOIDRATO, 140));
        add(new Alimento("Peito de Frango", GrupoAlimento.PROTEINA, 120));
        add(new Alimento("Patinho", GrupoAlimento.PROTEINA, 115));
        add(new Alimento("Tilapia", GrupoAlimento.PROTEINA, 106));
        add(new Alimento("Azeite", GrupoAlimento.LIPIDIOS, 300));
        add(new Alimento("Abacate", GrupoAlimento.LIPIDIOS, 260));
        add(new Alimento("Ovo", GrupoAlimento.LIPIDIOS, 80));
    }};

    public static void combinacaoAlimentos(Scanner in){

        System.out.println("Qual o consumo calórico do cliente?");
        Double consumoCalorico = in.nextDouble();

        Double caloriaEmCarboidrato = consumoCalorico * 0.5;
        Double caloriaEmProteina = consumoCalorico * 0.3;
        Double caloriaEmLipidios = consumoCalorico * 0.2;

        String consumoEmCarboidrato = null;
        String consumoEmProteina = null;
        String consumoEmLipidios = null;

        Map<String,Integer> carboidratos = new TreeMap<>();
        Map<String,Integer> lipideos = new TreeMap<>();
        Map<String,Integer> proteinas = new TreeMap<>();

        Map<String, Integer> carboidratosOrdenados = new LinkedHashMap<>();
        Map<String, Integer> proteinasOrdenados = new LinkedHashMap<>();
        Map<String, Integer> lipideosOrdenados = new LinkedHashMap<>();
        String ultimaChave = null;
        Integer ultimoValor = null;


        for (int i = 0; i< alimentos.size(); i++){
            if (alimentos.get(i).getGrupoAlimento().equals(GrupoAlimento.CARBOIDRATO)){
                Integer qtdPorcoes = (int) (caloriaEmCarboidrato / alimentos.get(i).getCalorias()); //6
                carboidratos.put(alimentos.get(i).getNomeAlimento(), qtdPorcoes * 100);
                carboidratosOrdenados = ordenarPorValor(carboidratos);

            }

            if (alimentos.get(i).getGrupoAlimento().equals(GrupoAlimento.PROTEINA)){
                Integer qtdPorcoes = (int) (caloriaEmProteina / alimentos.get(i).getCalorias()); //6
                proteinas.put(alimentos.get(i).getNomeAlimento(), qtdPorcoes * 100);
                proteinasOrdenados = ordenarPorValor(proteinas);
            }

            if (alimentos.get(i).getGrupoAlimento().equals(GrupoAlimento.LIPIDIOS)){
                Integer qtdPorcoes = (int) (caloriaEmLipidios / alimentos.get(i).getCalorias()); //6
                lipideos.put(alimentos.get(i).getNomeAlimento(), qtdPorcoes * 100);
                lipideosOrdenados = ordenarPorValor(lipideos);
            }
        }
        for (Map.Entry<String, Integer> entry : carboidratosOrdenados.entrySet()) {
            ultimaChave = entry.getKey();
            ultimoValor = entry.getValue();
        }

        System.out.println("Carboidrato: "+ ultimaChave + " Quantidade: "+ ultimoValor + "g");

        for (Map.Entry<String, Integer> entry : lipideosOrdenados.entrySet()) {
            ultimaChave = entry.getKey();
            ultimoValor = entry.getValue();
        }

        System.out.println("Lipídios: "+ ultimaChave + " Quantidade: "+ ultimoValor + "g");

        for (Map.Entry<String, Integer> entry : proteinasOrdenados.entrySet()) {
            ultimaChave = entry.getKey();
            ultimoValor = entry.getValue();
        }

        System.out.println("Proteínas: " + ultimaChave + " Quantidade: "+ ultimoValor + "g");

    }

    private static Map<String, Integer> ordenarPorValor(Map<String, Integer> mapa) {
        return mapa.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), Map::putAll);
    }
}
