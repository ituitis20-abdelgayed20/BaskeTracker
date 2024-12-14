package bees.basketball.dataLoader;

import bees.basketball.team.TeamService;
import bees.basketball.team.model.Team;
import bees.basketball.player.PlayerService;
import bees.basketball.player.model.Player;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Configuration
public class DataLoader {

    private final TeamService teamService;
    private final PlayerService playerService;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            if (teamService.getAllTeams().isEmpty()) {
                List<Team> sampleTeams = Arrays.asList(
                        createTeam("TÜRK TELEKOM", 10, 5, 15, 77),
                        createTeam("FENERBAHÇE BEKO", 12, 3, 15, 95),
                        createTeam("ANADOLU EFES", 11, 4, 15, 88),
                        createTeam("BEŞİKTAŞ EMLAKJET", 8, 7, 15, 73),
                        createTeam("FRUTTİ EXTRA BURSASPOR", 9, 6, 15, 81),
                        createTeam("DARÜŞŞAFAKA LASSA", 7, 8, 15, 68),
                        createTeam("TOFAŞ", 6, 9, 15, 65),
                        createTeam("GALATASARAY NEF", 5, 10, 15, 62)
                );
                teamService.createTeams(sampleTeams);
            }

            if (playerService.getAllPlayers().isEmpty()) {
                List<Player> players = Arrays.asList(
                        // Türk Telekom Players (ID 1)
                        createPlayer("Arda Özdoğan", "Guard", 12, 5, 4, 1.85, 3, 1, 25, 1L),
                        createPlayer("Atakan Murat Biçer", "Guard", 0, 0, 7, 1.88, 0, 0, 20, 1L),
                        createPlayer("Berk Demir", "Guard", 103, 30, 6, 1.90, 25, 3, 27, 1L),
                        createPlayer("Boran Güler", "Guard", 25, 19, 9, 1.78, 8, 2, 23, 1L),
                        createPlayer("Emircan Koşut", "Forward", 14, 3, 11, 2.02, 4, 1, 29, 1L),
                        createPlayer("Holdyn Jerian Grant", "Forward", 605, 37, 3, 1.98, 50, 15, 30, 1L),
                        createPlayer("Mehmet Yağmur", "Guard", 21, 25, 8, 1.88, 10, 4, 32, 1L),
                        createPlayer("Mevlüt Melih Doğan", "Forward", 2, 4, 15, 2.05, 1, 1, 22, 1L),
                        createPlayer("Michael Eric", "Center", 34, 3, 13, 2.10, 5, 3, 31, 1L),
                        createPlayer("Nathan Michael Sestina", "Forward", 390, 36, 10, 2.06, 20, 10, 28, 1L),
                        createPlayer("Semih Erden", "Center", 39, 30, 14, 2.13, 12, 7, 35, 1L),
                        createPlayer("Tyrique Daniel Jones", "Forward", 0, 0, 12, 2.00, 0, 0, 25, 1L),

                        // Fenerbahçe Beko Players (ID 2)
                        createPlayer("Carsen Cade Edwards", "Guard", 265, 13, 2, 1.85, 35, 5, 24, 2L),
                        createPlayer("Devin Rydale Booker", "Guard", 70, 5, 1, 1.88, 10, 3, 29, 2L),
                        createPlayer("Dyshawn-Dylan Pierre", "Forward", 202, 8, 25, 2.02, 30, 7, 27, 2L),
                        createPlayer("İsmet Akpınar", "Guard", 109, 5, 5, 1.90, 12, 4, 28, 2L),
                        createPlayer("James Metecan Birsen", "Forward", 142, 6, 16, 2.04, 15, 6, 26, 2L),
                        createPlayer("Johnathan Motley", "Center", 507, 15, 24, 2.10, 40, 10, 30, 2L),
                        createPlayer("Marko Guduric", "Forward", 227, 10, 26, 1.96, 25, 8, 27, 2L),
                        createPlayer("Melih Mahmutoğlu", "Guard", 237, 6, 30, 1.91, 20, 7, 33, 2L),
                        createPlayer("Ndubuisi Adetokunbo", "Guard", 23, 7, 22, 1.89, 8, 2, 22, 2L),
                        createPlayer("Nicholas William Calathes", "Guard", 154, 7, 20, 1.96, 15, 6, 34, 2L),
                        createPlayer("Nigel Hayes", "Forward", 391, 12, 21, 2.03, 30, 10, 29, 2L),
                        createPlayer("Scott Jordan Wilbekin", "Guard", 303, 31, 3, 1.88, 40, 10, 30, 2L),
                        createPlayer("Şehmus Hazer", "Guard", 204, 7, 35, 1.88, 15, 5, 24, 2L),
                        createPlayer("Tyler Quincy Dorsey", "Center", 0, 0, 23, 2.06, 0, 0, 25, 2L),

                        // Anadolu Efes Players (ID 3)
                        createPlayer("Shane Larkin", "Guard", 650, 130, 40, 1.80, 75, 10, 31, 3L),
                        createPlayer("Vasilije Micić", "Guard", 620, 128, 17, 1.96, 60, 5, 29, 3L),
                        createPlayer("Rodrigue Beaubois", "Guard", 460, 105, 29, 1.96, 45, 10, 32, 3L),
                        createPlayer("Doğuş Balbay", "Guard", 300, 95, 34, 1.93, 25, 15, 32, 3L),
                        createPlayer("Kenan Sipahi", "Guard", 310, 99, 27, 1.96, 35, 10, 26, 3L),
                        createPlayer("Adrien Moerman", "Forward", 510, 110, 45, 2.04, 50, 12, 32, 3L),
                        createPlayer("Chris Singleton", "Forward", 520, 115, 19, 2.03, 60, 10, 34, 3L),
                        createPlayer("James Anderson", "Forward", 460, 108, 37, 2.01, 40, 12, 31, 3L),
                        createPlayer("Will Clyburn", "Forward", 494, 14, 44, 2.02, 35, 7, 32, 3L),
                        createPlayer("Furkan Haltalı", "Forward", 88, 3, 51, 2.02, 10, 3, 22, 3L),
                        createPlayer("Tibor Pleiß", "Center", 540, 120, 33, 2.18, 30, 6, 35, 3L),
                        createPlayer("Bryant Dunston", "Center", 530, 116, 48, 2.06, 25, 8, 36, 3L),

                        // Beşiktaş Emlakjet Players (ID 4)
                        createPlayer("Oğuz Savaş", "Center", 212, 120, 64, 2.13, 15, 5, 33, 4L),
                        createPlayer("DJ White", "Center", 203, 115, 32, 2.06, 20, 6, 32, 4L),
                        createPlayer("Alex Perez", "Guard", 370, 100, 42, 1.95, 35, 10, 27, 4L),
                        createPlayer("Xavier Munford", "Guard", 420, 110, 50, 1.93, 40, 8, 28, 4L),
                        createPlayer("Jared Jordan", "Guard", 350, 98, 56, 1.96, 30, 12, 29, 4L),
                        createPlayer("Jordan Theodore", "Guard", 460, 108, 54, 1.88, 25, 6, 30, 4L),
                        createPlayer("Lorenzo Brown", "Guard", 460, 109, 48, 1.98, 35, 5, 32, 4L),
                        createPlayer("Joshua Smith", "Forward", 430, 105, 50, 2.01, 40, 9, 28, 4L),
                        createPlayer("James White", "Forward", 460, 112, 63, 2.02, 45, 8, 30, 4L),
                        createPlayer("Onuralp Bitim", "Forward", 350, 94, 36, 2.03, 35, 6, 24, 4L),
                        createPlayer("Berkay Candan", "Forward", 205, 95, 46, 1.98, 25, 4, 26, 4L),
                        createPlayer("Jamar Desean Smith", "Forward", 198, 105, 53, 2.00, 30, 6, 31, 4L),

                        // Frutti Extra Bursaspor Players (ID 5)
                        createPlayer("Andrew Delano Andrews", "Guard", 230, 52, 71, 1.93, 12, 8, 28, 5L),
                        createPlayer("Anthony Charles Clemmons", "Guard", 250, 56, 75, 1.85, 15, 10, 29, 5L),
                        createPlayer("Aubrey Lafell Dawkins", "Center", 210, 48, 18, 2.03, 8, 6, 27, 5L),
                        createPlayer("Aubrey Lafell Dawkins", "Guard", 190, 45, 33, 1.98, 7, 5, 28, 5L),
                        createPlayer("Berk Can Akin", "Guard", 210, 52, 80, 1.87, 10, 6, 27, 5L),
                        createPlayer("Mehmet Nihat Atalan", "Guard", 220, 54, 74, 1.92, 13, 7, 26, 5L),
                        createPlayer("Enes Berkay Taşkıran", "Guard", 200, 50, 96, 1.90, 9, 6, 25, 5L),
                        createPlayer("Mithat Can Özalp", "Forward", 210, 53, 88, 1.98, 11, 8, 26, 5L),
                        createPlayer("Ömer Utku Al", "Forward", 230, 55, 59, 2.00, 15, 9, 27, 5L),
                        createPlayer("Zachary Auguste", "Forward", 220, 56, 67, 2.05, 12, 6, 28, 5L),

                        // Darüşşafaka Lassa Players (ID 6)
                        createPlayer("Aaron Richard White", "Forward", 170, 45, 77, 2.03, 8, 6, 28, 6L),
                        createPlayer("Abodunrin Gabriel Olaseni", "Forward", 160, 42, 81, 2.02, 7, 5, 27, 6L),
                        createPlayer("Akwasi Abeyie Yeboah", "Forward", 150, 40, 86, 1.99, 6, 4, 26, 6L),
                        createPlayer("Derrick Williams", "Forward", 170, 44, 58, 2.04, 8, 5, 28, 6L),
                        createPlayer("Petr Cornelie", "Forward", 180, 46, 70, 2.06, 9, 6, 29, 6L),
                        createPlayer("Will Cummings", "Guard", 160, 43, 52, 1.93, 12, 7, 27, 6L),
                        createPlayer("Markel Brown", "Guard", 170, 45, 66, 1.96, 10, 6, 28, 6L),
                        createPlayer("Scottie Wilbekin", "Guard", 150, 40, 87, 1.93, 8, 6, 29, 6L),
                        createPlayer("Jason Rich", "Guard", 160, 42, 72, 1.92, 9, 5, 27, 6L),
                        createPlayer("Anthony Markel Starks II", "Guard", 140, 68, 85, 1.91, 8, 5, 26, 6L),
                        createPlayer("Zach Auguste", "Center", 180, 48, 84, 2.10, 14, 8, 30, 6L),
                        createPlayer("Sertaç Şanlı", "Center", 190, 50, 91, 2.13, 12, 7, 31, 6L),

                        // Tofaş Players (ID 7)
                        createPlayer("Arturas Milaknis", "Guard", 180, 46, 93, 1.97, 6, 5, 27, 7L),
                        createPlayer("Brady Reece Manek", "Forward", 200, 48, 78, 2.03, 7, 6, 28, 7L),
                        createPlayer("Milton Edward Doyle", "Guard", 190, 45, 95, 1.95, 8, 6, 26, 7L),
                        createPlayer("Berke Büyüktuncel", "Forward", 170, 43, 28, 1.98, 5, 5, 25, 7L),
                        createPlayer("Mustafa Kurtuldum", "Guard", 160, 42, 41, 1.92, 6, 4, 27, 7L),
                        createPlayer("Tolga Geçim", "Forward", 180, 45, 60, 2.01, 7, 6, 28, 7L),
                        createPlayer("Batın Tuna", "Guard", 220, 50, 94, 1.94, 9, 7, 29, 7L),
                        createPlayer("Ege Demir", "Forward", 240, 55, 69, 2.05, 10, 8, 28, 7L),
                        createPlayer("Tevfik Akdamar", "Guard", 170, 42, 55, 1.88, 7, 5, 26, 7L),
                        createPlayer("Özgür Cengiz", "Center", 200, 48, 39, 2.08, 12, 6, 30, 7L),
                        createPlayer("Bülent Hamza Çelik", "Center", 220, 50, 47, 2.10, 14, 7, 31, 7L),

                        // Galatasaray Nef Players (ID 8)
                        createPlayer("Angelo Caloiaro", "Forward", 210, 48, 38, 2.03, 10, 6, 28, 8L),
                        createPlayer("Dusan Ristic", "Center", 180, 45, 49, 2.13, 12, 7, 29, 8L),
                        createPlayer("Tyrus Bresdon McGee", "Guard", 200, 50, 43, 1.98, 9, 5, 27, 8L),
                        createPlayer("Muhaymin Mustafa", "Guard", 180, 46, 62, 1.94, 8, 6, 28, 8L),
                        createPlayer("Hüseyin Göksenin Köksal", "Guard", 230, 55, 57, 1.93, 12, 8, 29, 8L),
                        createPlayer("Berke İsmailçebi", "Forward", 190, 48, 61, 2.00, 10, 7, 27, 8L),
                        createPlayer("Ege Tan Yıldızıoğlu", "Forward", 220, 50, 73, 2.02, 11, 8, 28, 8L),
                        createPlayer("Efe Vatan", "Guard", 210, 49, 90, 1.90, 9, 5, 27, 8L),
                        createPlayer("Hüseyin Göksenin Köksal", "Forward", 250, 55, 82, 2.05, 13, 9, 30, 8L),
                        createPlayer("Sertaç Şanlı", "Center", 240, 53, 76, 2.13, 14, 8, 31, 8L)

                );

                playerService.createPlayers(players);
            }
        };
    }

    private Team createTeam(String name, int wins, int losses, int totalGamePlayed, int totalScore) {
        Team team = new Team();
        team.setName(name);
        team.setWins(wins);
        team.setLosses(losses);
        team.setTotalGamePlayed(totalGamePlayed);
        team.setTotalScore(totalScore);
        return team;
    }

    private Player createPlayer(
            String fullName, String position, int totalScore, int totalGamePlayed,
            int jerseyNumber, double height, int steals, int losses, int age, Long teamId
    ) {
        Player player = new Player();
        player.setFullName(fullName);
        player.setPosition(position);
        player.setTotalScore(totalScore);
        player.setTotalGamePlayed(totalGamePlayed);
        player.setJerseyNumber(jerseyNumber);
        player.setHeight(height);
        player.setSteals(steals);
        player.setLosses(losses);
        player.setAge(age);
        player.setTeam(teamService.getTeamById(teamId));
        return player;
    }

}
