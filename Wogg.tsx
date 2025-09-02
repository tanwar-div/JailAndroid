// App.tsx
import React, { useEffect, useState } from 'react';
import { Button, Text, TextInput, View } from 'react-native';

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
      if(result) console.error("chrome opened")
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
      <View style={{ padding: 20 }}>       
        <Button title="Reverse String with Native Code" onPress={handlePress} />
        <Button title={"Start Blocking"} onPress={handlestate} />
        <Text>{`${inputb}`}</Text>
        

        <TextInput
          placeholder="Hours"
          keyboardType="numeric"
          value={hours}
          onChangeText={setHours}
        />
        <TextInput
          placeholder="Minutes"
          keyboardType="numeric"
          value={minutes}
          onChangeText={setMinutes}
        />
        {btime !== null && <Text>Stored time: {btime} ms</Text>}
        
        <Text>{Math.floor(timeLeft / 3600)} hours {Math.floor((timeLeft % 3600) / 60)} minutes {timeLeft%60} s left</Text>
      </View>
  );
};

export default App;