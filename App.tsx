/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

//MAIN YAHA PAR RUN HOTA HAI

import { Button } from 'react-native';
import { StatusBar, StyleSheet, useColorScheme, View } from 'react-native';
import {
  SafeAreaProvider,
  useSafeAreaInsets,
} from 'react-native-safe-area-context';
import Togg from './Togg';
import Wogg from './Wogg';

function App() {

  const isDarkMode = useColorScheme() === 'dark';

  return (
    <SafeAreaProvider>
      <StatusBar barStyle={isDarkMode ? 'light-content' : 'dark-content'} />
      <AppContent />
    </SafeAreaProvider>
  );
}

function AppContent() {
  const safeAreaInsets = useSafeAreaInsets();

  return (
    <View style={styles.container}>
      <Wogg/>
      <Togg />
      <Button 
        title="Click me" 
        color="#841584"
       />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});

export default App;
