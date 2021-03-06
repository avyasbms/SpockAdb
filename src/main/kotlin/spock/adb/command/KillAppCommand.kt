package spock.adb.command

import com.android.ddmlib.IDevice
import com.intellij.openapi.project.Project
import javassist.NotFoundException
import spock.adb.isAppInstall
import spock.adb.killApp

class KillAppCommand:Command<String,Unit> {
    override fun execute(p: String, project: Project, device: IDevice) {
        if (device.isAppInstall(p))
            device.killApp(p, 15L)
        else
            throw NotFoundException("Application $p not installed" )
    }
}