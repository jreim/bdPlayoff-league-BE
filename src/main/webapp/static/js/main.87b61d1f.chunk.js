(this["webpackJsonpplayoff-league-fe"]=this["webpackJsonpplayoff-league-fe"]||[]).push([[0],{124:function(e,t,a){},133:function(e,t,a){e.exports=a(317)},138:function(e,t,a){},139:function(e,t,a){},140:function(e,t,a){},141:function(e,t,a){},142:function(e,t,a){},312:function(e,t,a){},313:function(e,t,a){},314:function(e,t,a){},317:function(e,t,a){"use strict";a.r(t);var n=a(0),l=a.n(n),s=a(21),r=a.n(s),i=(a(138),a(139),a(4)),c=a(8),o=a(9),m=a(11),u=a(10),d=a(13),h=a(12),f=(a(140),a(141),function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={x:Array()},["QB","RB","WR","TE","K","DST"].map((function(t){e.players.map((function(e){e.position===t&&a.state.x.push(e)}))})),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){this.setState({data:[]})}},{key:"getClazz",value:function(e){return void 0!=e.team2?"row text-left text-muted":void 0!=e.team1?"row text-left text-warning":"row text-left text-primary"}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:""},this.state.x.map((function(t,a){return n.createElement("div",{className:e.getClazz(t)},n.createElement("div",{className:"col-2"},t.position),n.createElement("div",{className:"col-8"},t.name))})))}}]),t}(n.Component)),p=a(7),v=a.n(p),y=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={nflTeams:[],players:[]},a.getPlayers=a.getPlayers.bind(Object(d.a)(a)),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"getPlayers",value:function(){var e=this;console.log("run"),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){console.log(t),e.setState(Object(i.a)({},e.state,{players:t,nflTeams:e.state.nflTeams})),e.forceUpdate()}))}},{key:"componentDidMount",value:function(){var e=this;this.setState({nflTeams:[],isLoading:!0,players:[]}),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){return e.setState({players:t,isLoading:!0,nflTeams:e.state.nflTeams}),fetch(window.name+"/static/nflTeams").then((function(e){return e.json()})).then((function(t){return e.setState({nflTeams:t,isLoading:!1,players:e.state.players})}))}))}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:"container"},n.createElement("div",{className:"row"},v.a.filter(this.state.nflTeams,(function(e){return"AFC"===e.conf})).map((function(t,a){return n.createElement("div",{className:"col"},n.createElement("div",{className:"row "},n.createElement("h3",{className:"col-12"},t.name)),n.createElement("div",{className:"row"},n.createElement(f,{key:t.name,players:v.a.filter(e.state.players,(function(e){return e.nflTeam.name===t.name}))})))}))),n.createElement("div",{className:"row"},v.a.filter(this.state.nflTeams,(function(e){return"NFC"===e.conf})).map((function(t,a){return n.createElement("div",{className:"col"},n.createElement("div",{className:"row justify-content-center"},n.createElement("h3",null,t.name)),n.createElement("div",{className:""},n.createElement(f,{key:t.name,players:v.a.filter(e.state.players,(function(e){return e.nflTeam.name===t.name}))})))}))))}}]),t}(n.Component),E=(a(81),a(130)),b=a(24),g=a(126),j=(a(142),a(37)),O=a(14),T=a(53),k=a(52),w=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={teamName:"",teamEmail:"",teams:[]},a.handleChange=a.handleChange.bind(Object(d.a)(a)),a.handleSubmit=a.handleSubmit.bind(Object(d.a)(a)),a.randomDraft=a.randomDraft.bind(Object(d.a)(a)),a.deleteTeam=a.deleteTeam.bind(Object(d.a)(a)),a.getNeeds=a.getNeeds.bind(Object(d.a)(a)),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"loadTeams",value:function(){var e=this;console.log(window.name+"/team"),fetch(window.name+"/team").then((function(e){return e.json()})).then((function(t){e.setState(Object(i.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")}))}))}},{key:"componentDidMount",value:function(){this.loadTeams()}},{key:"handleSubmit",value:function(e){var t=this;console.log(this.state),e.preventDefault(),fetch(window.name+"/team",{method:"POST",body:JSON.stringify({name:this.state.teamName,email:this.state.teamEmail}),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(e){t.state.teams.push(e),t.setState(Object(i.a)({},t.state,{teams:v.a.sortBy(t.state.teams,"draftPos"),teamName:"",teamEmail:""}))})).catch((function(e){alert(e)}))}},{key:"handleChange",value:function(e){"name"===e.target.id&&this.setState(Object(i.a)({},this.state,{teamName:e.target.value})),"email"===e.target.id&&this.setState(Object(i.a)({},this.state,{teamEmail:e.target.value}))}},{key:"randomDraft",value:function(){var e=this;fetch(window.name+"/team/shuffle").then((function(e){return e.json()})).then((function(t){e.setState(Object(i.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")}))}))}},{key:"deleteTeam",value:function(e){var t=this;fetch(window.name+"/team/"+e,{method:"DELETE"}).then((function(e){t.setState(Object(i.a)({},t.state,{teams:v.a.sortBy(e,"draftPos")}))}))}},{key:"startDraft",value:function(){fetch(window.name+"/draft/start",{method:"GET"}).then((function(e){alert("Draft is started , no mo teams can be added.")}))}},{key:"getNeeds",value:function(e){var t;if(t=["QB","RB","RB","WR/TE","WR/TE","WR/TE","K","DST"],console.log(e.players),e.players){var a=!0,n=!1,l=void 0;try{for(var s,r=e.players[Symbol.iterator]();!(a=(s=r.next()).done);a=!0){var i=s.value.position;"TE"!==i&&"WR"!=i||(i="WR/TE"),t.indexOf(i)>-1&&t.splice(t.indexOf(i),1)}}catch(c){n=!0,l=c}finally{try{a||null==r.return||r.return()}finally{if(n)throw l}}}return JSON.stringify(t)}},{key:"render",value:function(){var e=this;return n.createElement("div",{className:"row"},n.createElement(g.a,{size:"sm"},n.createElement("thead",null,n.createElement("tr",null,n.createElement("th",null,"Draft Pos"),n.createElement("th",null,"Name"),n.createElement("th",null,"email"),n.createElement("th",null,"remaining"),n.createElement("th",null,"util"))),n.createElement("tbody",null,this.state.teams.map((function(t,a){return n.createElement("tr",null,n.createElement("td",null,t.draftPos),n.createElement("td",null,t.name),n.createElement("td",null,t.email),n.createElement("td",null,e.getNeeds(t)),n.createElement("td",null,n.createElement(k.b,{onClick:function(){e.deleteTeam(t.id)}})))})))),n.createElement("div",{className:"row"}),n.createElement(j.a,{onSubmit:this.handleSubmit},n.createElement(j.a.Row,null,n.createElement(O.a,null,n.createElement(j.a.Control,{id:"name",type:"text",value:this.state.teamName,onChange:this.handleChange})),n.createElement(O.a,null,n.createElement(j.a.Control,{id:"email",type:"text",value:this.state.teamEmail,onChange:this.handleChange})),n.createElement(O.a,null,n.createElement(T.a,{variant:"primary",type:"submit"},"Add Team")),n.createElement(O.a,null,n.createElement(T.a,{variant:"primary",onClick:this.randomDraft},"shuffle draft")),n.createElement(O.a,null,n.createElement(T.a,{variant:"primary",onClick:this.startDraft},"Start draft")))))}}]),t}(n.Component),N=a(128),S=(a(124),function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state=e,a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){var e=this;return n.createElement("div",{className:"row"},n.createElement("div",{className:"col-1"},this.state.pick.draftPos),n.createElement("div",{className:"col-1"},this.state.pick.roundPick),n.createElement("div",{className:"col-4"},this.state.pick.teamName),n.createElement("div",{className:"col-4"},this.state.pick.playerName),n.createElement("div",{className:"col-1"},n.createElement(k.a,{onClick:function(){e.state.editPick(e.state.pick.draftPos)}})))}}]),t}(n.Component)),C=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={players:[],teams:[],picks:[],pickNumber:1,player:{position:"",id:0,name:"",nflTeam:{name:"",conf:"",logo:""},team1:void 0,team2:void 0,eliminated:!1,wcw:{id:0,score:0,passYd:0,recYd:0,rushYd:0,tPt:0,rushTd:[],passRecTd:[],xp:0,fg:[],dst:0,elim:!1}}},a.handleChange=a.handleChange.bind(Object(d.a)(a)),a.handleSubmit=a.handleSubmit.bind(Object(d.a)(a)),a.editTeam=a.editTeam.bind(Object(d.a)(a)),a.getNeeds=a.getNeeds.bind(Object(d.a)(a)),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"loadTeams",value:function(){var e=this;fetch(window.name+"/team").then((function(e){return e.json()})).then((function(t){return e.setState(Object(i.a)({},e.state,{teams:v.a.sortBy(t,"draftPos")})),fetch(window.name+"/player").then((function(e){return e.json()})).then((function(t){return e.setState(Object(i.a)({},e.state,{players:t})),fetch(window.name+"/draft").then((function(e){return e.json()})).then((function(t){e.setState(Object(i.a)({},e.state,{picks:v.a.orderBy(t,["draftPos"]),pickNumber:e.getPickNumber(v.a.orderBy(t,["draftPos"]))}))}))}))}))}},{key:"getPickNumber",value:function(e){if(0===e.length)return 1;for(var t=!1,a=0;!t;)a==e.length&&(t=!0,a=0),0==e[a].playerId||void 0==e[a].playerId?t=!0:a+=1;return a+1}},{key:"componentDidMount",value:function(){this.loadTeams()}},{key:"handleSubmit",value:function(e){var t=this;fetch(window.name+"/draft/pick/"+this.state.picks[this.state.pickNumber-1].id+"?playerId="+this.state.player.id,{method:"PUT",headers:{"Content-Type":"application/json"}}).then((function(e){200==e.status?(t.state.picks[t.state.pickNumber-1].playerName=t.state.player.name,t.state.picks[t.state.pickNumber-1].playerId=t.state.player.id,t.setState(Object(i.a)({},t.state,{pickNumber:t.getPickNumber(t.state.picks)})),t.setState(Object(i.a)({},t.state,{player:void 0}))):alert("something"),console.log(e)})).catch((function(e){console.log(e)})),e.preventDefault()}},{key:"handleChange",value:function(e){this.setState(Object(i.a)({},this.state,{player:e[0]}))}},{key:"editTeam",value:function(e){this.setState(Object(i.a)({},this.state,{pickNumber:e}))}},{key:"getNeeds",value:function(e){this.state.teams.map((function(t){if(t.id.toString()==e){var a;if(a=["QB","RB","RB","WR/TE","WR/TE","WR/TE","K","DST"],t.players){var n=!0,l=!1,s=void 0;try{for(var r,i=t.players[Symbol.iterator]();!(n=(r=i.next()).done);n=!0){var c=r.value.position;"TE"!==c&&"WR"!=c||(c="WR/TE"),a.indexOf(c)>-1&&a.splice(a.indexOf(c),1)}}catch(o){l=!0,s=o}finally{try{n||null==i.return||i.return()}finally{if(l)throw s}}}alert(a)}}))}},{key:"render",value:function(){var e=this;return n.createElement("div",null,n.createElement("div",{className:"row tableFixHead"},n.createElement(j.a,{onSubmit:this.handleSubmit},n.createElement(j.a.Row,null,n.createElement(O.a,null,n.createElement(N.Typeahead,{id:"playersTypeAhead",labelKey:function(e){return e.name+"-"+e.position},filterBy:["name"],options:this.state.players,placeholder:"Player",onChange:this.handleChange})),n.createElement(O.a,null,n.createElement(T.a,{variant:"primary",type:"submit"},"Draft Player"))))),n.createElement("div",{className:"row"},n.createElement("div",{className:"col-1"},"pick#"),n.createElement("div",{className:"col-1"},"round.Pick"),n.createElement("div",{className:"col-4"},"Team"),n.createElement("div",{className:"col-4"},"Player"),n.createElement("div",{className:"col-2"},"Utils")),this.state.picks.map((function(t,a){return n.createElement("div",{className:e.state.pickNumber===t.draftPos?"pick":""},n.createElement(S,{key:e.state.pickNumber,pick:t,players:e.state.players,pickNumber:e.state.pickNumber,editPick:e.editTeam,getNeeds:e.getNeeds}))})))}}]),t}(n.Component),P=(a(312),a(320)),x=a(321),R=a(322),B=a(319),D=(a(313),function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,["QB","RB","RB","WR/TE","WR/TE","WR/TE","K","DST"],a.state={players:[]},["QB","RB","WR","TE","K","DST"].map((function(t){e.players.map((function(e){e.position===t&&a.setState(Object(i.a)({},a.state,{players:a.state.players.push(e)}))}))})),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"render",value:function(){return n.createElement(R.a.Body,{className:"teamHeader"},n.createElement(B.a,null,n.createElement(O.a,{lg:"1"},"Pos."),n.createElement(O.a,{lg:"2"},"Player"),n.createElement(O.a,{lg:"1"},"Wild card"),n.createElement(O.a,{lg:"1"},"Divisonal"),n.createElement(O.a,{lg:"2"},"Championship"),n.createElement(O.a,{lg:"2"},"Super bowl"),n.createElement(O.a,{lg:"1"},"Total")),this.state.players.map((function(e){return n.createElement(B.a,null,n.createElement(O.a,{lg:"1"},e.position),n.createElement(O.a,{lg:"2"},e.name),n.createElement(O.a,{lg:"1"},void 0==e.wcw?"x":e.wcw.score))})))}}]),t}(n.Component)),Y=function(e){function t(){var e;return Object(c.a)(this,t),(e=Object(m.a)(this,Object(u.a)(t).call(this,{}))).state=void 0,e.state={teams:[]},e}return Object(h.a)(t,e),Object(o.a)(t,[{key:"loadTeams",value:function(){var e=this;fetch(window.name+"/team/scoreView").then((function(e){return e.json()})).then((function(t){e.setState(Object(i.a)({},e.state,{teams:v.a.sortBy(t,"score")}))}))}},{key:"componentDidMount",value:function(){this.loadTeams()}},{key:"render",value:function(){return n.createElement(P.a,null,n.createElement(x.a,null,n.createElement(R.a,null,n.createElement(B.a,{className:"header"},n.createElement(O.a,{lg:4},"Team Name"),n.createElement(O.a,{lg:2},"Players remaining"),n.createElement(O.a,{lg:2},"Score"),n.createElement(O.a,{lg:2},"Details"))),this.state.teams.map((function(e){return n.createElement(R.a,null,n.createElement(x.a.Toggle,{as:R.a.Header,eventKey:e.name},n.createElement(B.a,null,n.createElement(O.a,{lg:4},e.name),n.createElement(O.a,{lg:2},e.playersRemaining),n.createElement(O.a,{lg:2},e.score))),n.createElement(x.a.Collapse,{eventKey:e.name},n.createElement(D,{key:e.id,players:e.players})))}))))}}]),t}(n.Component),W=(a(314),function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,console.log("wildCard"===e.round&&!v.a.isUndefined(e.player.wcw)+" "+e.round+" "+e.player.wcw),"wildCard"!==e.round||v.a.isUndefined(e.player.wcw)?a.state={player:e.player,round:e.round,stat:{id:0,score:0,passYd:0,recYd:0,rushYd:0,tPt:0,rushTd:[],rushTdStr:"",passRecTd:[],passRecTdStr:"",xp:0,fg:[],fgStr:"",dst:0,elim:!1}}:(a.state={player:e.player,round:e.round,stat:e.player.wcw},a.forceUpdate()),a.hit=a.hit.bind(Object(d.a)(a)),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"hit",value:function(){var e;if(void 0!==this.state.stat){var t=this.strToArray(this.state.stat.rushTdStr),a=this.strToArray(this.state.stat.passRecTdStr),n=this.strToArray(this.state.stat.fgStr);e={id:this.state.stat.id,score:this.state.stat.score,passYd:this.state.stat.passYd,recYd:this.state.stat.recYd,rushYd:this.state.stat.rushYd,tPt:this.state.stat.tPt,rushTd:t,passRecTd:a,xp:this.state.stat.xp,fg:n,fgStr:"",dst:this.state.stat.dst,elim:this.state.stat.elim},console.log(JSON.stringify(e)),fetch(window.name+"/stat/player/"+this.state.player.id,{method:"POST",body:JSON.stringify(e),headers:{"Content-Type":"application/json"}}).then((function(e){return e.json()})).then((function(e){alert("saved")})).catch((function(e){alert(e)}))}}},{key:"strToArray",value:function(e){if(void 0!==e){if(""===e)return[];for(var t=e.split(","),a=[],n=0;n<t.length;)a.push(parseInt(t[n])),n++;return a}return[]}},{key:"render",value:function(){var e,t,a,n,s,r,c,o,m,u=this;return l.a.createElement("tr",null,l.a.createElement("td",{className:"nameClass"},this.state.player.position),l.a.createElement("td",{className:"nameClass"},this.state.player.name),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".passYd",value:null===(e=this.state.stat)||void 0===e?void 0:e.passYd,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{passYd:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".recYd",value:null===(t=this.state.stat)||void 0===t?void 0:t.recYd,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{recYd:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".rushYd",value:null===(a=this.state.stat)||void 0===a?void 0:a.rushYd,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{rushYd:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".tPt",value:null===(n=this.state.stat)||void 0===n?void 0:n.tPt,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{tPt:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".rushTd",value:null===(s=this.state.stat)||void 0===s?void 0:s.rushTdStr,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{rushTdStr:e.target.value})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".passRecTdStr",value:null===(r=this.state.stat)||void 0===r?void 0:r.passRecTdStr,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{passRecTdStr:e.target.value})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".fgStr",value:null===(c=this.state.stat)||void 0===c?void 0:c.fgStr,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{fgStr:e.target.value})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".xp",value:null===(o=this.state.stat)||void 0===o?void 0:o.xp,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{xp:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"text",id:this.state.player.id+".dst",value:null===(m=this.state.stat)||void 0===m?void 0:m.dst,onChange:function(e){u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{dst:parseInt(e.target.value)})}))}})),l.a.createElement("td",null,l.a.createElement("input",{type:"checkbox",id:this.state.player.id+".eliminated",onChange:function(e){var t;u.setState(Object(i.a)({},u.state,{stat:Object(i.a)({},u.state.stat,{elim:!(null===(t=u.state.stat)||void 0===t?void 0:t.elim)})}))}})),l.a.createElement("td",null,l.a.createElement(T.a,{onClick:function(){u.hit()}},"score")))}}]),t}(l.a.Component)),I=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={team:e.team,players:[],round:e.round},a.hit=a.hit.bind(Object(d.a)(a)),a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){var e=this;fetch(window.name+"/player/scoreView/byTeam?team="+this.state.team.name).then((function(e){return e.json()})).then((function(t){var a=v.a.filter(t,(function(t){return t.nflTeam.name===e.state.team.name&&!v.a.isUndefined(t.team1)}));e.setState(Object(i.a)({},e.state,{players:a}))}))}},{key:"hit",value:function(e){this.state.players.map((function(t){e.target.id===t.id+".passYd"&&(t.wcw.passYd=parseInt(e.target.value))}))}},{key:"render",value:function(){var e=this;return l.a.createElement(R.a.Body,{className:"teamHeader"},l.a.createElement(B.a,null,l.a.createElement(O.a,{lg:"12"},l.a.createElement(g.a,{striped:!0,bordered:!0,hover:!0,variant:"dark",size:"small"},l.a.createElement("thead",null,l.a.createElement("tr",null,l.a.createElement("th",{className:"nameClass"},"Pos"),l.a.createElement("th",{className:"nameClass"},"Player"),l.a.createElement("th",null,"passYd"),l.a.createElement("th",null,"recYd"),l.a.createElement("th",null,"rushYd"),l.a.createElement("th",null,"tPt"),l.a.createElement("th",null,"rushTd"),l.a.createElement("th",null,"passRecTd"),l.a.createElement("th",null,"fg"),l.a.createElement("th",null,"xp"),l.a.createElement("th",null,"dst"),l.a.createElement("th",null,"eliminated"),l.a.createElement("th",null,"go"))),l.a.createElement("tbody",null,this.state.players.map((function(t){return l.a.createElement(W,{key:t.id,player:t,round:e.state.round})})))))))}}]),t}(l.a.Component),K=function(e){function t(e){var a;return Object(c.a)(this,t),(a=Object(m.a)(this,Object(u.a)(t).call(this,e))).state=void 0,a.state={games:[]},a}return Object(h.a)(t,e),Object(o.a)(t,[{key:"componentDidMount",value:function(){console.log("componentDidMount"),this.loadTeams()}},{key:"loadTeams",value:function(){var e=this;console.log("loadTeams"),fetch(window.name+"/game").then((function(e){return e.json()})).then((function(t){console.log(t),e.setState(Object(i.a)({},e.state,{games:v.a.sortBy(t,"order")}))}))}},{key:"render",value:function(){return n.createElement(P.a,null,n.createElement(x.a,null,this.state.games.map((function(e){return n.createElement(R.a,null,n.createElement(x.a.Toggle,{as:R.a.Header,eventKey:e.order.toString()},n.createElement(B.a,null,n.createElement(O.a,{lg:4},e.homeTeam.name," vs ",e.awayTeam.name))),n.createElement(x.a.Collapse,{eventKey:e.order.toString()},n.createElement(R.a.Body,null,e.homeTeam.name,n.createElement(I,{key:e.homeTeam.name,team:e.homeTeam,players:[],round:e.round}),e.awayTeam.name,n.createElement(I,{key:e.awayTeam.name,team:e.awayTeam,players:[],round:e.round}))))}))))}}]),t}(n.Component),A=function(){return window.name="",l.a.createElement(E.a,null,l.a.createElement("div",{className:"App"},l.a.createElement("ul",{className:"nav nav-tabs"},l.a.createElement("li",{className:"nav-item"},l.a.createElement("a",{className:"nav-link ",href:"/"},"Scores")),l.a.createElement("li",{className:"nav-item"},l.a.createElement("a",{className:"nav-link",href:"/playerPage"},"Player Page")),l.a.createElement("li",{className:"nav-item"},l.a.createElement("a",{className:"nav-link",href:"/draftPage"},"Draft")),l.a.createElement("li",{className:"nav-item"},l.a.createElement("a",{className:"nav-link",href:"/gamez"},"Games and stats"))),l.a.createElement(b.c,null,l.a.createElement(b.a,{exact:!0,path:"/",component:Y}),l.a.createElement(b.a,{exact:!0,path:"/playerPage",component:y}),l.a.createElement(b.a,{exact:!0,path:"/teamPage",component:w}),l.a.createElement(b.a,{exact:!0,path:"/draftPage",component:C}),l.a.createElement(b.a,{exact:!0,path:"/gamez",component:K}))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));r.a.render(l.a.createElement(A,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))}},[[133,1,2]]]);
//# sourceMappingURL=main.87b61d1f.chunk.js.map