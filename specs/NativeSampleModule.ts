// THIS IS THE FILE:  NativeSampleModule.ts

import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

// This defines what your module looks like to JavaScript
export interface Spec extends TurboModule {
  reverseString(input: boolean): boolean;
}

// This registers the module so you can import it
export default TurboModuleRegistry.get<Spec>('SampleModule');