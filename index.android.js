// /**
//  * Sample React Native App
//  * https://github.com/facebook/react-native
//  * @flow
//  */

import React, { Component } from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  TouchableHighlight
} from 'react-native';
import Sumup from './Api/Sumup';

//var Sumup = require('./SumupModule.android');


export default class SumupSampleReact extends Component {
  _onLoginPress() {
        Sumup.login()
  }
  _onChargePress() {
        Sumup.charge()
  }
  _onSettingsPress() {
        Sumup.paymentSettings()
  }
  _onCheckoutPress() {
        Sumup.prepareCardTerminal()
  }
  _onLogoutPress() {
        Sumup.logout()
  }

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          REACT SAMPLE SUMUP - MEIFACIL
        </Text>


        {/* <Text>Your awesome app</Text>
        <TouchableHighlight onPress={this._onLoginPress}>
            <View style={styles.login}>
                <Text style={styles.whiteFont}>Login with Sumup</Text>
            </View>
        </TouchableHighlight> */}
        <View/>
        <TouchableHighlight  onPress={this._onChargePress}>
            <View style={styles.login}>
                <Text style={styles.charge}>Charge with Sumup Sample</Text>
            </View>
        </TouchableHighlight>
        <View/>
        {/* <TouchableHighlight onPress={this._onSettingsPress}>
            <View style={styles.login}>
                <Text style={styles.whiteFont}>Payment Settings with Sumup</Text>
            </View>
        </TouchableHighlight> */}

         {/* <TouchableHighlight onPress={this._onCheckoutPress}>
             <View style={styles.login}>
                 <Text style={styles.whiteFont}>Prepare Card Terminal with Sumup</Text>
            </View>
         </TouchableHighlight>
         <View/>
         <TouchableHighlight onPress={this._onLogoutPress}>
             <View style={styles.login}>
                 <Text style={styles.whiteFont}>Logout with Sumup</Text>
             </View>
         </TouchableHighlight> */}
      </View>

    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },

  instructions: {
    textAlign: 'center',
    color: '#333333',
    marginBottom: 5,
  },
  charge: {
    fontSize: 16,
    textAlign: 'center',
    backgroundColor: '#2EA5DA',
    color:'white',
    margin: 10,
  },
});
// import {
//   StackNavigator,
// } from 'react-navigation';
// import {HomeScreen} from './HomeScreen';
// import {ProfileScreen} from './ProfileScreen';

// const App = StackNavigator({
//   Home: { screen: HomeScreen },
//   Profile: { screen: ProfileScreen },
// });

AppRegistry.registerComponent('SumupSampleReact', () => SumupSampleReact);
