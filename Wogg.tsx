// App.tsx
import React, { useEffect, useState } from 'react';
import { View, Text, TouchableOpacity, TextInput, StyleSheet } from 'react-native';
// 1. Import your native module from the spec file
// The path depends on your project structure.
import SampleModule from './specs/NativeSampleModule';

const App = () => {
  const [inputb, setInputb] = useState(false);
  const [hours, setHours] = useState("");
  const [minutes, setMinutes] = useState("");
  const [btime, setBtime] = useState(0);
  const [currtime, setcurr] = useState(0);
  const [timeLeft, setTimeLeft] = useState(0);

  const handlePress = () => {
    if (SampleModule) {
      const result = SampleModule.reverseString(inputb);
    } else {
      console.error("The native module 'SampleModule' is not available.");
    }
  };

  const handlestate = () => {
    if (SampleModule && currtime + btime < Date.now()) {
      
      const h = parseInt(hours) || 0;
      const m = parseInt(minutes) || 0;
      const asdf = (h * 60 + m) * 60 * 1000;
      setBtime(asdf);
      SampleModule.setsara(true, asdf);
      setcurr(Date.now());
      setTimeLeft(asdf / 1000);
    } else {
      console.error("Already blocking!");
    }
  };

  useEffect(() => {
    if (timeLeft <= 0) return;

    const interval = setInterval(() => {
      setTimeLeft(prev => prev - 1);
    }, 1000);

    return () => clearInterval(interval);
  }, [timeLeft]);

  return (
    <View style={styles.container}>
      <View style={styles.card}>
        
        {/* Top Button */}
        <TouchableOpacity style={styles.topButton} onPress={handlePress}>
          <Text style={styles.topButtonText}>ALLOW ACCESSIBILITY SETTINGS FOR APP</Text>
        </TouchableOpacity>

        {/* Timer / Input */}
        {timeLeft === 0 ? (
          <View style={styles.inputContainer}>
            <TextInput
              placeholder="Hours"
              placeholderTextColor="#9CA3AF"
              keyboardType="numeric"
              value={hours}
              onChangeText={setHours}
              style={styles.input}
            />
            <TextInput
              placeholder="Minutes"
              placeholderTextColor="#9CA3AF"
              keyboardType="numeric"
              value={minutes}
              onChangeText={setMinutes}
              style={styles.input}
            />

            {btime !== null && <Text style={styles.storedText}>Stored time: {btime} ms</Text>}
          </View>
        ) : (
          <Text style={styles.timer}>
            {Math.floor(timeLeft / 3600)}h {Math.floor((timeLeft % 3600) / 60)}m {timeLeft % 60}s left
          </Text>
        )}

        {/* Bottom Button */}
        <TouchableOpacity style={styles.bottomButton} onPress={handlestate}>
          <Text style={styles.bottomButtonText}>MAKE APP ADMIN and start blocking</Text>
        </TouchableOpacity>

      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#111827', // Tailwind bg-gray-900
    justifyContent: 'center',
    alignItems: 'center',
  },
  card: {
    backgroundColor: 'rgba(31,41,55,0.7)', // bg-gray-800/70
    padding: 30,
    borderRadius: 20,
    borderWidth: 1,
    borderColor: '#374151', // border-gray-700
    alignItems: 'center',
    width: '85%',
    shadowColor: '#000',
    shadowOpacity: 0.3,
    shadowRadius: 20,
    shadowOffset: { width: 0, height: 10 },
    elevation: 10,
  },
  topButton: {
    backgroundColor: '#374151', // bg-gray-700
    paddingVertical: 12,
    paddingHorizontal: 20,
    borderRadius: 9999,
    borderWidth: 1,
    borderColor: '#4B5563', // border-gray-600
    marginBottom: 20,
  },
  topButtonText: {
    color: '#fff',
    fontWeight: '500',
    textAlign: 'center',
  },
  inputContainer: {
    alignItems: 'center',
    width: '100%',
  },
  input: {
    backgroundColor: '#374151',
    color: '#fff',
    borderWidth: 1,
    borderColor: '#4B5563',
    borderRadius: 8,
    width: '80%',
    padding: 10,
    marginBottom: 12,
  },
  storedText: {
    color: '#d1d5db', // gray-300
    marginTop: 5,
  },
  timer: {
    color: '#fff',
    fontSize: 18,
    marginVertical: 20,
  },
  bottomButton: {
    backgroundColor: '#EA580C', // orange-600
    paddingVertical: 12,
    paddingHorizontal: 24,
    borderRadius: 9999,
    marginTop: 10,
  },
  bottomButtonText: {
    color: '#fff',
    fontWeight: '500',
    textAlign: 'center',
  },
});


export default App;