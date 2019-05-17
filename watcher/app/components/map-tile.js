import Component from '@ember/component';

export default Component.extend({

  tagName: 'td',
  classNames: ['map-tile'],
  _markedPlayerClass: 'map-tile-player',

  markPlayer: false,
  markContent: false,

  content: [],
  x: -1,
  y: -1,

  init() {
      this._super();
      var content = this.get('content');

      if(content.length > 0){
          if(this.get('x') == content[0].position.x && this.get('y') == content[0].position.y ){
              this.toggleProperty('markPlayer')
          } else {
              this.toggleProperty('markContent')
          }
      }
  }

});
