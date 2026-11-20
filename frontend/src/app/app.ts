import { Component } from '@angular/core';

import { Navbar } from './shared/navbar/navbar';
import { Footer } from './shared/footer/footer';
import { Home } from './features/home/home';
import { About } from './features/about/about';
import { Skills } from './features/skills/skills';
import { Projects } from './features/projects/projects';
import { Experience } from './features/experience/experience';
import { Contact } from './features/contact/contact';

@Component({
  selector: 'app-root',
  imports: [
    Navbar,
    Footer,
    Home,
    About,
    Skills,
    Projects,
    Experience,
    Contact
  ],
  templateUrl: './app.html',
  styleUrl: './app.scss'
})
export class App {
}
