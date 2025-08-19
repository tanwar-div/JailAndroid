// App.tsx
import React, { useState } from 'react';
import { Button, Text, TextInput, View } from 'react-native';

// 1. Import your native module from the spec file
// The path depends on your project structure.
import SampleModule from './specs/NativeSampleModule';

const App = () => {
  const [inputb, setInputb] = useState(false);

  const handlePress = () => {
    if (SampleModule) {
      // 2. Call the function directly on the imported module
      setInputb(!inputb)
      const result = SampleModule.reverseString(inputb);
      if(result) console.error("chrome opened")
    } else {
      console.error("The native module 'SampleModule' is not available.");
    }
  };

  return (
      <View style={{ padding: 20 }}>       
        <Button title="Reverse String with Native Code" onPress={handlePress} />
        <Text>{`${inputb}`}</Text>
      </View>
  );
};

export default App;