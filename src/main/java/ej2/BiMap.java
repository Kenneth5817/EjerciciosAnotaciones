package ej2;

import java.util.HashMap;
import java.util.Map;

public class BiMap<K, V> {

    private final Map<K, V> keyToValue;
    private final Map<V, K> valueToKey;

    // Constructor
    public BiMap() {
        this.keyToValue = new HashMap<>();
        this.valueToKey = new HashMap<>();
    }

    // Método put: Añadir un par (k, v) si no existe, o actualizarlo si es necesario
    public BiMap<K, V> put(K key, V value) {
        // Verificar si el valor ya está en el mapa de valores (bidireccionalidad)
        if (valueToKey.containsKey(value)) {
            if (!valueToKey.get(value).equals(key)) {
                throw new IllegalArgumentException("El valor '" + value + "' ya está asociado con otra clave.");
            }
        }
        // Si la clave ya existe, actualizamos el valor asociado
        if (keyToValue.containsKey(key)) {
            // Removemos el valor anterior de valueToKey
            V oldValue = keyToValue.get(key);
            valueToKey.remove(oldValue);
        }

        // Añadimos o actualizamos el par clave-valor
        keyToValue.put(key, value);
        // Añadimos el valor invertido (valor-clave)
        valueToKey.put(value, key);

        return this;
    }

    // Método forcePut: Añadir un par (k, v) sin verificar si ya existe
    public BiMap<K, V> forcePut(K key, V value) {
        // Si la clave ya existe, removemos el valor anterior en valueToKey
        if (keyToValue.containsKey(key)) {
            V oldValue = keyToValue.get(key);
            valueToKey.remove(oldValue);
        }

        // Si el valor ya existe, removemos la clave anterior
        if (valueToKey.containsKey(value)) {
            K oldKey = valueToKey.get(value);
            keyToValue.remove(oldKey);
        }

        // Añadimos el par (clave, valor)
        keyToValue.put(key, value);
        // Añadimos el par inverso (valor, clave)
        valueToKey.put(value, key);

        return this;
    }

    // Método inv: Devuelve un BiMap invertido
    public BiMap<V, K> inv() {
        BiMap<V, K> invertedBiMap = new BiMap<>();
        for (Map.Entry<K, V> entry : keyToValue.entrySet()) {
            invertedBiMap.put(entry.getValue(), entry.getKey());
        }
        return invertedBiMap;
    }

    // Método get por clave
    public V get(K key) {
        return keyToValue.get(key);
    }

    // Método get por valor
    public K getByValue(V value) {
        return valueToKey.get(value);
    }

    // Método containsKey
    public boolean containsKey(K key) {
        return keyToValue.containsKey(key);
    }

    // Método containsValue
    public boolean containsValue(V value) {
        return valueToKey.containsKey(value);
    }

    // Método size
    public int size() {
        return keyToValue.size();
    }
}
