// App.tsx
import React, { useState } from 'react';
import { Button, Text, TextInput, View } from 'react-native';

// 1. Import your native module from the spec file
// The path depends on your project structure.
import SampleModule from './specs/NativeSampleModule';

const App = () => {
  const [inputText, setInputText] = useState('Hello World');
  const [reversedText, setReversedText] = useState('');

  const handlePress = () => {
    if (SampleModule) {
      // 2. Call the function directly on the imported module
      const result = SampleModule.reverseString(inputText);
      setReversedText(result);
    } else {
      console.error("The native module 'SampleModule' is not available.");
    }
  };

  return (
      <View style={{ padding: 20 }}>
        <Text>Input:</Text>
        <TextInput
          value={inputText}
          onChangeText={setInputText}
          style={{ borderWidth: 1, padding: 8, marginVertical: 10 }}
        />
        <Button title="Reverse String with Native Code" onPress={handlePress} />
        <Text style={{ marginTop: 20, fontSize: 18 }}>
          Reversed: {reversedText}
        </Text>
      </View>
  );
};

export default App;