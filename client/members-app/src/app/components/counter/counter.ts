import { Component } from '@angular/core';

@Component({
  selector: 'app-counter',
  imports: [],
  templateUrl: './counter.html',
  styleUrl: './counter.scss'
})
export class CounterComponent {
  private startTime: number = 0;
  public timer: string = "00:00:00 seconds";
  private intervalId:any;

  public convert(timer: number){
    const TotalSeconds = Math.floor(timer);
    const hours = Math.floor( TotalSeconds / 3600);
    const minutes = Math.floor(hours/60);
    const seconds = TotalSeconds % 60;

    const pad = (num: number) => num.toString().padStart(2,'0');
    return `${pad(hours)}:${pad(minutes)}:${pad(seconds)}`;
  }
  public onStart(){
    this.timer = "00:00:00";
    this.startTime = Date.now();
    this.intervalId = setInterval(() => {
      const elapsedSeconds = (Date.now() - this.startTime)/1000;
      this.timer = this.convert(elapsedSeconds);
    })
  }

  public onEnd(){
    let endTime = Date.now();
    if(this.intervalId){
      clearInterval(this.intervalId);
    }
    const elapsedTime = (endTime - this.startTime)/1000;
    this.timer = this.convert(elapsedTime);
  }

  public onReset(){
    this.timer = "00:00:00";
    clearInterval(this.intervalId);
  }

}
